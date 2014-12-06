/* Theme Name: Worthy - Free Powerful Theme by HtmlCoder
 * Author:HtmlCoder
 * Author URI:http://www.htmlcoder.me
 * Version:1.0.0
 * Created:November 2014
 * License: Creative Commons Attribution 3.0 License (https://creativecommons.org/licenses/by/3.0/)
 * File Description: Place here your custom scripts
 */

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
var panelListId = $('#panelDevicesList');

/**
 * Jquery Constants
 */
var devicesList = "";
var sosInterval = "";
var sesInterval = "";

function onProcessClicked(processId) {
	document.getElementById("panelPropertyId").innerHTML = processTagIconHTML
			+ "  " + processId;
	panelListId.empty();
	$.get("/client/process/" + processId + "/sensors", function(data) {
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
	clearInterval(sesInterval);

	sosInterval = setInterval(function() {
		pollSOSValues(processId);
	}, 3000);
	sesInterval = setInterval(function() {
		pollSESValues(processId);
	}, 3000);

}

function pollSOSValues(processId) {
	console.log("polling sos values for processId:" + processId);
	$(devicesList).each(
			function(index, item) {
				if (item.type === "sensor")
					$.post("/client/sensor?procedure=" + item.logicalId,
							function(data) {
								document.getElementById(item.logicalId + "_"
										+ item.parameterName).innerHTML = data;
							});
			});
}

function pollSESValues(processId) {
	console.log("polling ses values for processId:" + processId);
}

function onParameterChanged(element, index) {
	console.log(devicesList[index].parameterName + " change for sensor id:"
			+ devicesList[index].logicalId + " has changed to:"
			+ element.checked);
	$.post("/client/task?procedure=" + devicesList[index].logicalId
			+ "&values=" + element.checked);
}

function onParameterSelected(element, index) {
	console
			.log(devicesList[index].parameterName + " selection for sensor id:"
					+ devicesList[index].logicalId + " has changed to:"
					+ element.value);
	$.post("/client/task?procedure=" + devicesList[index].logicalId
			+ "&values=" + element.value);
}
