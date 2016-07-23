'use strict';

angular.module('Home')

.controller('HomeController',
		    function ($scope,serviceId) {
	 serviceId.getDeptrank('2015', '2', function (response) {
	        // Create the chart
	       var series=response;
	    	$('#container0').highcharts({
	            chart: {
	                type: 'column'
	            },
	            title: {
	                text: '2nd SEM'
	            },
	            xAxis: {
	                type: 'category'
	            },
	            yAxis: {
	                title: {
	                    text: 'Total pass percent'
	                }

	            },
	            legend: {
	                enabled: false
	            },
	            plotOptions: {
	                series: {
	                    borderWidth: 0,
	                    dataLabels: {
	                        enabled: true,
	                        format: '{point.y:.1f}%'
	                    }
	                }
	            },

	            tooltip: {
	                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
	                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
	            },
	        series    
	    	}); }); 
    
    serviceId.getDeptrank('2015', '4', function (response) {
        // Create the chart
       var series=response;
    	$('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: '4th SEM'
            },
            xAxis: {
                type: 'category'
            },
            yAxis: {
                title: {
                    text: 'Total pass percent'
                }

            },
            legend: {
                enabled: false
            },
            plotOptions: {
                series: {
                    borderWidth: 0,
                    dataLabels: {
                        enabled: true,
                        format: '{point.y:.1f}%'
                    }
                }
            },
            tooltip: {
                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
            },
        series    
    	}); }); 
    	
    	
    	 serviceId.getDeptrank('2015', '6', function (response) {
    	        // Create the chart
    	       var series=response;
    	    	$('#container1').highcharts({
    	            chart: {
    	                type: 'column'
    	            },
    	            title: {
    	                text: '6th SEM'
    	            },
    	            xAxis: {
    	                type: 'category'
    	            },
    	            yAxis: {
    	                title: {
    	                    text: 'Total pass percent'
    	                }

    	            },
    	            legend: {
    	                enabled: false
    	            },
    	            plotOptions: {
    	                series: {
    	                    borderWidth: 0,
    	                    dataLabels: {
    	                        enabled: true,
    	                        format: '{point.y:.1f}%'
    	                    }
    	                }
    	            },
    	            tooltip: {
    	                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
    	                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
    	            },
    	        series    
    	        });  });
    	 
    	
    	 serviceId.getDeptrank('2015', '8', function (response) {
 	        // Create the chart
 	       var series=response;
 	    	$('#container2').highcharts({
	            chart: {
	                type: 'column'
	            },
	            title: {
	                text: '8th SEM'
	            },
	            xAxis: {
	                type: 'category'
	            },
	            yAxis: {
	                title: {
	                    text: 'Total pass percent'
	                }

	            },
	            legend: {
	                enabled: false
	            },
	            plotOptions: {
	                series: {
	                    borderWidth: 0,
	                    dataLabels: {
	                        enabled: true,
	                        format: '{point.y:.1f}%'
	                    }
	                }
	            },
 	            tooltip: {
 	                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
 	                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
 	            },
 	        series    
 	    	}); }); 
});