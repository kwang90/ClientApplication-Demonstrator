/**
 * HTML Constants
 */
var sensorSelectionListHTML = "<option>$SENSORID</option>";
var selectionListId = $('#form_select_id');

/**
 * Jquery Constants
 */
var devicesList = "";

$(document).ready(
		function() {
			plotChartForSensorData(2);
			console.log("document ready");
			$.get("/client/sensors", function(data) {
				devicesList = JSON.parse(data).devices;
				$(devicesList).each(
						function(index, item) {
							var sensorHTML = sensorSelectionListHTML.replace(
									"$SENSORID", item.processId + "=>"
											+ item.parameterName);
							selectionListId.append(sensorHTML);
						});
			});
		});

function onParameterSelected(element) {
	var sensor = devicesList[element.selectedIndex];
	document.getElementById("chart_panel_heading").innerHTML = element.value;
	console.log(sensor.parameterName + " selection for sensor id:"
			+ sensor.logicalId + " has changed to:" + element.value);
	$.get("/client/sensors/" + sensor.logicalId + "/chart", function(data) {
		var chartData = JSON.parse(data).data;
		plotChartForSensorData(chartData);
	});
}

function plotChartForSensorData(data, minVal, maxVal) {
	plot(data, minVal, maxVal);

	function plot(data, minVal, maxVal) {
		var plot = $.plot($("#flot-line-chart"), [], options);
		var dataArray = [];
		$(data).each(function(index, item) {
			dataArray.push([ item.time, item.value ]);

		});

		var options = {
			series : {
				lines : {
					show : true
				},
				points : {
					show : true
				}
			},
			grid : {
				hoverable : true
			// IMPORTANT! this is needed for tooltip to work
			},
			yaxis : {
				min : minVal,
				max : maxVal
			},
			tooltip : true,
			tooltipOpts : {
				content : "'%s' of %x.1 is %y.4",
				shifts : {
					x : -60,
					y : 25
				}
			}
		};

		var plotObj = $.plot($("#flot-line-chart"), [ {
			data : dataArray,
			label : "Measurements"
		} ], options);
	}
}
