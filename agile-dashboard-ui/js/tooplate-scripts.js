const width_threshold = 480;



const baseUrl = "http://localhost:8080/api/reports";
function ajaxVelocityPredict(){
	  console.log("inside ajaxVelocityPredict" );
	
		var data = {}
			data["projectName"] = "test";
			data["reportName"] = "VELOCITY_PREDICTABILITY";
		
		var vellab = new Set(); 
		var vel =[];
		var pred =[];
			$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: baseUrl,
		             data: JSON.stringify(data),
		             dataType: 'json',
		             timeout: 600000,
		             success: function (data) {
		                  console.log(data);
						  console.log(data.chartDetails);
						  $.each(data.chartDetails, function(i, item) {
							 
							console.log(item.chartName);
							$.each(item.chartData, function(i, chartdata) {
								console.log(chartdata.xValue);
								vellab.add(chartdata.xValue);
								if(item.chartName == 'Velocity'){
								vel.push(chartdata.yValue);
								}else{
								pred.push(chartdata.yValue);
								}
								console.log(chartdata.yValue);
							});
						});
						
						velocityPredictability(Array.from(vellab),vel, pred);
		             },
		             error: function (e) {
		                console.log(e);
		             }
			});
		
		
}

function ajaxScopeChange(){
	  console.log("inside ajaxVelocityPredict" );
	
		var data = {}
			data["projectName"] = "test";
			data["reportName"] = "SCOPE_CHANGE";
		
		var vellab = new Set(); 
		var vel =[];
		var pred =[];
			$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: baseUrl,
		             data: JSON.stringify(data),
		             dataType: 'json',
		             timeout: 600000,
		             success: function (data) {
		                  console.log(data);
						  console.log(data.chartDetails);
						  $.each(data.chartDetails, function(i, item) {
							 
							console.log(item.chartName);
							$.each(item.chartData, function(i, chartdata) {
								console.log(chartdata.xValue);
								vellab.add(chartdata.xValue);
								if(item.chartName == 'Scope Change'){
								vel.push(chartdata.yValue);
								}else{
								pred.push(chartdata.yValue);
								}
								console.log(chartdata.yValue);
							});
						});
						
						drawScopeChange(Array.from(vellab),vel,pred);
		             },
		             error: function (e) {
		                console.log(e);
		             }
			});
		
		
}

function ajaxPriority(){
	  console.log("inside ajaxVelocityPredict" );
	
		var data = {}
			data["projectName"] = "test";
			data["reportName"] = "PRIORITY";
		
		//var vellab =[];
		var vellab = new Set(); 
		var lowest =[];
		var low =[];
		var medium =[];
		var high =[];
		var highest =[];
			$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: baseUrl,
		             data: JSON.stringify(data),
		             dataType: 'json',
		             timeout: 600000,
		             success: function (data) {
		                  console.log(data);
						  console.log(data.chartDetails);
						  $.each(data.chartDetails, function(i, item) {
							 
							console.log(item.chartName);
							$.each(item.chartData, function(i, chartdata) {
								console.log(chartdata.xValue);
								vellab.add(chartdata.xValue);
								if(item.chartName == 'Lowest'){
								lowest.push(chartdata.yValue);
								}else if(item.chartName == 'Low'){
									low.push(chartdata.yValue);
								}else if(item.chartName == 'Medium'){
									medium.push(chartdata.yValue);
								}else if(item.chartName == 'High'){
									high.push(chartdata.yValue);
								}
								else{
									highest.push(chartdata.yValue);
								}
								console.log(chartdata.yValue);
							});
						});
						
						drawBarChart( Array.from(vellab) ,lowest,low,medium,high,highest);
		             },
		             error: function (e) {
		                console.log(e);
		             }
			});
		
		
}

function ajaxAcceptCommit(){
	  console.log("inside ajaxAcceptCommit" );
	
		var data = {}
			data["projectName"] = "test";
			data["reportName"] = "ACCEPT_COMMITTED";
		
		var vellab = new Set();
		var vel =[];
		var pred =[];
			$.ajax({
		             type: "POST",
		             contentType: "application/json",
		             url: baseUrl,
		             data: JSON.stringify(data),
		             dataType: 'json',
		             timeout: 600000,
		             success: function (data) {
		                  console.log(data);
						  console.log(data.chartDetails);
						  $.each(data.chartDetails, function(i, item) {
							 
							console.log(item.chartName);
							$.each(item.chartData, function(i, chartdata) {
								console.log(chartdata.xValue);
								vellab.add(chartdata.xValue);
								if(item.chartName == 'Accepted/Committed'){
								vel.push(chartdata.yValue);
								}else{
								pred.push(chartdata.yValue);
								}
								console.log(chartdata.yValue);
							});
						});
						
						drawAcceptCommit(Array.from(vellab),vel);
		             },
		             error: function (e) {
		                console.log(e);
		             }
			});
		
		
}

function velocityPredictability(vellab, velocity, velpredic) {
	 console.log("inside velocityPredictability" );
	//ajaxVelocityPredict();
	 console.log("completed ajaxVelocityPredict" );
  if ($("#velocityPredictabilityChart").length) {
    ctxLine = document.getElementById("velocityPredictabilityChart").getContext("2d");
    configBar = {
      type: "bar",
      data: {
        labels: vellab,
        datasets: [
          {
            type: 'line',
            fill: false,
            label: "Velocity Predictability line",
            data: velpredic,
             backgroundColor: [
                '#ab4830',
                '#ab4830',
                '#ab4830',
                '#ab4830',
                
            ],
           
          },{
            type: 'bar',
            
            label: "Velocity Predictability",
            data: velocity,
            fillColor : "#48A497",
            strokeColor : "#48A4D1",
            backgroundColor: [
                '#f0b400',
                '#f0b400',
                '#f0b400',
                '#f0b400',
            ],
            
          },
          
        ]
      }
    };
    velocityPredictabilityChart = new Chart(ctxLine, configBar);
  }
}

function drawBarChart(vellab,lowest,low,medium,high,highest) {
  if ($("#barChart").length) {
    // start
    var barChartData = {
			labels: vellab,
			datasets: [{
				label: 'Lowest',
				backgroundColor: "#8c00f0",
				data: lowest
			}, {
				label: 'Low',
				backgroundColor: "#4dc451",
				data: low
			},{
				label: 'High',
				backgroundColor: "#f0b400",
				data: high
			},
       {
				label: 'Highest',
				backgroundColor: "#00abf0",
				data: highest
			},
       {
				label: 'Medium',
				backgroundColor: "#4c273f",
				data: medium
			}
      ]

		};
			var ctx = document.getElementById('barChart').getContext('2d');
			window.myBar = new Chart(ctx, {
				type: 'bar',
				data: barChartData,
				options: {
					title: {
						display: false,
						text: ''
					},
					tooltips: {
						mode: 'index',
						intersect: false
					},
					responsive: true,
					scales: {
						xAxes: [{
							stacked: true,
						}],
						yAxes: [{
							stacked: true
						}]
					}
				}
			});
		
    // end 
  }
}

function drawAcceptCommit(vellab, velocity) {
  if ($("#AcceptCommit").length) {
    ctxBar = document.getElementById("AcceptCommit").getContext("2d");

    optionsBar = {
      responsive: true,
      scales: {
        yAxes: [
          {
            ticks: {
              beginAtZero: true
            },
            scaleLabel: {
              display: true,
              labelString: ""
            }
          }
        ]
      }
    };

    optionsBar.maintainAspectRatio =
      $(window).width() < width_threshold ? false : true;

    configBar = {
      type: "bar",
      data: {
        labels: vellab,
        datasets: [
          {
            label: "Accepted/Commited",
            data: velocity,
            backgroundColor: [
              "#f0b400",
              "#f0b400",
              "#f0b400",
              "#f0b400",
              
            ],
            
          }
        ]
      },
      options: optionsBar
    };

    barChart = new Chart(ctxBar, configBar);
  }
}


function drawScopeChange(vellab, velocity,pred) {
  if ($("#ScopeChange").length) {
    // start
    
    var barChartData = {
			labels: vellab,
			datasets: [{
				label: 'Commited Work',
				backgroundColor: "#f0b400",
				data: pred
			},
			{
				label: 'Added scope',
				backgroundColor: "#8c00f0",
				data: velocity
			}]

		};
			var ctx = document.getElementById('ScopeChange').getContext('2d');
			window.myBar = new Chart(ctx, {
				type: 'bar',
				data: barChartData,
				options: {
					title: {
						display: false,
						text: ''
					},
					tooltips: {
						mode: 'index',
						intersect: false
					},
					responsive: true,
					scales: {
						xAxes: [{
							stacked: true,
						}],
						yAxes: [{
							stacked: true
						}]
					}
				}
			});
		
    // end 
  }
}

function drawPieChart() {
  if ($("#pieChart").length) {
    ctxPie = document.getElementById("pieChart").getContext("2d");
    optionsPie = {
      responsive: true,
      maintainAspectRatio: false
    };

    configPie = {
      type: "pie",
      data: {
        datasets: [
          {
            data: [4600, 5400],
            backgroundColor: [
              window.chartColors.purple,
              window.chartColors.green
            ],
            label: "Storage"
          }
        ],
        labels: ["Used: 4,600 GB", "Available: 5,400 GB"]
      },
      options: optionsPie
    };

    pieChart = new Chart(ctxPie, configPie);
  }
}

function updateChartOptions() {
  if ($(window).width() < width_threshold) {
    if (optionsLine) {
      optionsLine.maintainAspectRatio = false;
    }
    if (optionsBar) {
      optionsBar.maintainAspectRatio = false;
    }
  } else {
    if (optionsLine) {
      optionsLine.maintainAspectRatio = true;
    }
    if (optionsBar) {
      optionsBar.maintainAspectRatio = true;
    }
  }
}

function updatevelocityPredictabilityChart() {
  if (velocityPredictabilityChart) {
    velocityPredictabilityChart.options = optionsLine;
    velocityPredictabilityChart.update();
  }
}

function updateBarChart() {
  if (barChart) {
    barChart.options = optionsBar;
    barChart.update();
  }
}

function reloadPage() {
  setTimeout(function() {
    window.location.reload();
  }); // Reload the page so that charts will display correctly
}

function drawCalendar() {
  if ($("#calendar").length) {
    $("#calendar").fullCalendar({
      height: 400,
      events: [
        {
          title: "Meeting",
          start: "2018-09-1",
          end: "2018-09-2"
        },
        {
          title: "Marketing trip",
          start: "2018-09-6",
          end: "2018-09-8"
        },
        {
          title: "Follow up",
          start: "2018-10-12"
        },
        {
          title: "Team",
          start: "2018-10-17"
        },
        {
          title: "Company Trip",
          start: "2018-10-25",
		  end: "2018-10-27"
        },
        {
          title: "Review",
          start: "2018-11-12"
        },
        {
          title: "Plan",
          start: "2018-11-18"
        }
      ],
      eventColor: "rgba(54, 162, 235, 0.4)"
    });
  }
}
