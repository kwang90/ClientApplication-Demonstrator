/**
 * HTML Constants
 */
var processTagIconHTML = "<i class=\"fa fa-list fa-fw\"></i>";
var deviceIconHTML = "<i class=\"fa fa-cog fa-fw\"></i> $PARAMETER_NAME ";
var deviceListSpanHTML = "<span class=\"pull-right text-muted small\">$PARAMETER_TYPE </span>";
var actuatorListHTML = "<input type=\"checkbox\" onchange=\"onParameterChanged(this,'$INDEX')\" $IS_CHECKED data-toggle=\"switch\" class=\"ct-info\"/>";
var actuatorSelectionListHTML = "<div class=\"form-group\"><select class=\"form-control\" onchange=\"onParameterSelected(this,'$INDEX')\"> <option>1</option> <option>2</option> <option>4</option> </select></div>";
var actuatorIsCheckedHTML = "checked";
var sensorListHTML = "<p id=\"$SENSORID\" class=\"text-primary\">$VALUE</p>";
var listGroupItemPrefixHTML = "<a class=\"list-group-item\">";
var listGroupItemSuffixHTML = "</a>";
var notificationHTML = "<a class=\"list-group-item\"> <i class=\"fa fa-bell fa-fw\"></i>$NOTIFICATION_TEXT<span class=\"pull-right text-muted small\"><em>$NOTIFICATION_TIME</em></span></a>";

var panelListId = $('#panelDevicesList');
var notificationsListId = $('#notificationsList');

/**
 * Jquery Constants
 */
var devicesList = "";
var sosInterval = "";
var sesInterval = "";

$(document).ready(function() {
	sesInterval = setInterval(function() {
		pollSESValues();
	}, 5000);
});

function onProcessClicked(processId) {
	document.getElementById("panelPropertyId").innerHTML = processTagIconHTML
			+ "  " + processId;
	panelListId.empty();
	$.get("/client/processes/" + processId + "/sensors", function(data) {
		devicesList = JSON.parse(data).devices;
		$(devicesList).each(
				function(index, item) {
					var parameterHTML = "";
					var iconHTML = deviceIconHTML.replace("$PARAMETER_NAME",
							item.parameterName);
					if (item.type === "actuator") {
						var actuatorHTML = "";
						if (item.parameterType === "Boolean") {
							if (item.value === "0")
								actuatorHTML = actuatorListHTML.replace(
										"$IS_CHECKED", "");
							else
								actuatorHTML = actuatorListHTML.replace(
										"$IS_CHECKED", actuatorIsCheckedHTML);
							actuatorHTML = actuatorHTML
									.replace("$INDEX", index);
						} else
							actuatorHTML = actuatorSelectionListHTML.replace(
									"$INDEX", index);
						var spanHTML = deviceListSpanHTML.replace(
								"$PARAMETER_TYPE", actuatorHTML);
						parameterHTML = listGroupItemPrefixHTML + iconHTML
								+ spanHTML + listGroupItemSuffixHTML;
					} else if (item.type === "sensor") {
						var sensorHTML = sensorListHTML.replace("$SENSORID",
								item.logicalId + "_" + item.parameterName)
								.replace("$VALUE", item.value);
						var spanHTML = deviceListSpanHTML.replace(
								"$PARAMETER_TYPE", sensorHTML);
						parameterHTML = listGroupItemPrefixHTML + iconHTML
								+ spanHTML + listGroupItemSuffixHTML;
					}
					console.log(parameterHTML);
					panelListId.append(parameterHTML);
				});
	});
	$.getScript("/client/js/gsdk-checkbox.js");
	$.getScript("/client/js/gsdk-bootstrapswitch.js");
	$.getScript("/client/js/get-shit-done.js");

	clearInterval(sosInterval);

	sosInterval = setInterval(function() {
		pollSOSValues(processId);
	}, 5000);
}

function pollSOSValues(processId) {
	console.log("polling sos values for processId:" + processId);
	$(devicesList).each(
			function(index, item) {
				if (item.type === "sensor")
					$.get("/client/sensors/" + item.logicalId + "/value",
							function(data) {
								document.getElementById(item.logicalId + "_"
										+ item.parameterName).innerHTML = data;
							});
			});
}

function pollSESValues() {
	console.log("polling ses values");
	$.get(
			"/client/notifications?page="
					+ notificationsListId.children().length, function(data) {
				var notificationsList = JSON.parse(data).notifications;
				$(notificationsList).each(
						function(index, item) {
							var notification = notificationHTML.replace(
									"$NOTIFICATION_TEXT", item.text).replace(
									"$NOTIFICATION_TIME", item.time);
							notificationsListId.append(notification);
						});
			});
}

function onParameterChanged(element, index) {
	console.log(devicesList[index].parameterName + " change for sensor id:"
			+ devicesList[index].logicalId + " has changed to:"
			+ element.checked);
	$.post("/client/tasks?procedure=" + devicesList[index].logicalId
			+ "&values=" + element.checked);
}

function onParameterSelected(element, index) {
	console
			.log(devicesList[index].parameterName + " selection for sensor id:"
					+ devicesList[index].logicalId + " has changed to:"
					+ element.value);
	$.post("/client/tasks?procedure=" + devicesList[index].logicalId
			+ "&values=" + element.value);
}
