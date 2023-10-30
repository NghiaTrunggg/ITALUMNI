<%-- 
    Document   : thongke
    Created on : Oct 26, 2023, 8:53:00 PM
    Author     : Admin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.NumberFormat" %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<!DOCTYPE html>

<h1 class="text-center text-info">THỐNG KÊ</h1>


<div class="container mt-5">
    <div class="row">
    <div class="col-md-12">
        <div class="input-group mb-3">
            <select id="yearSelectTour" class="form-select">
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
            </select>
            <button onclick="updateTourChart()" class="btn btn-primary ml-2">Thống kê theo tháng</button>
            <button onclick="updateTourQuarterChart()" class="btn btn-primary ml-2">Thống kê theo quý</button>
            <button onclick="updateTourYearChart()" class="btn btn-primary ml-2">Thống kê theo năm</button>
        </div>
    </div>
    </div>
    <div id="chart_tour"></div>
</div>


<script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(function () {
        loadTourCountData('2023');
    });

    function loadTourCountData(selectedYearTour) {
        fetch(`/AlumniApp/api/thongke/?years=\${selectedYearTour}`)
                .then(response => response.json())
                .then(data => {
                    drawTourChart(data);
                    console.log(data);
                })
                .catch(error => {
                    console.error('Lỗi khi tải dữ liệu số lượng tour:', error);
                });
    }

    function loadTourQuarterData(selectedYearTour) {
        fetch(`/AlumniApp/api/thongke/?years=\${selectedYearTour}`)
                .then(response => response.json())
                .then(data => {
                    drawTourQuarterChart(data);
                    console.log(data);
                })
                .catch(error => {
                    console.error('Lỗi khi tải dữ liệu số lượng tour theo quý:', error);
                });
    }

    function loadTourYearData() {
        // Gọi API để lấy dữ liệu số lượng tour của mỗi năm
        fetch(`/AlumniApp/api/thongke/?years.isEmpty()`)
                .then(response => response.json())
                .then(data => {
                    drawTourYearChart(data);
                    console.log(data);
                })
                .catch(error => {
                    console.error('Lỗi khi tải dữ liệu số lượng tour theo năm:', error);
                });
    }

   

    function drawTourChart(data) {
        var dataTable = new google.visualization.DataTable();
        dataTable.addColumn('number', 'Tháng');
        dataTable.addColumn('number', 'Số lượng');

        // Thêm dữ liệu từ data vào DataTable
        for (var i = 0; i < data.length; i++) {
            var month = data[i][2];
            var quantity = data[i][5];
            dataTable.addRow([month, quantity]);
        }

        var options = {
            title: 'Biểu đồ thống kê số lượng tour theo tháng',
            width: '1100',
            height: '500',
            hAxis: {title: 'Tháng', ticks: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]},
            vAxis: {title: 'Số lượng'},
            bars: 'vertical'
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_tour'));
        chart.draw(dataTable, options);
    }

    function drawTourQuarterChart(data) {
        var dataTable = new google.visualization.DataTable();
        dataTable.addColumn('string', 'Quý');
        dataTable.addColumn('number', 'Số lượng');


        var quarterCounts = {
            'Quý 1': 0,
            'Quý 2': 0,
            'Quý 3': 0,
            'Quý 4': 0
        };


        for (var i = 0; i < data.length; i++) {
            var quarter = data[i][3];
            var quantity = data[i][5];

            switch (quarter) {
                case 1:
                    quarterCounts['Quý 1'] += quantity;
                    break;
                case 2:
                    quarterCounts['Quý 2'] += quantity;
                    break;
                case 3:
                    quarterCounts['Quý 3'] += quantity;
                    break;
                case 4:
                    quarterCounts['Quý 4'] += quantity;
                    break;
            }
        }

        // Thêm dữ liệu đã tính vào DataTable
        for (var q in quarterCounts) {
            dataTable.addRow([q, quarterCounts[q]]);
        }

        var options = {
            title: 'Biểu đồ thống kê số lượng tour theo quý',
            width: '1100',
            height: '500',
            hAxis: {title: 'Quý'},
            vAxis: {title: 'Số lượng'},
            bars: 'vertical'
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_tour'));
        chart.draw(dataTable, options);
    }

    function drawTourYearChart(data) {
        var dataTable = new google.visualization.DataTable();
        dataTable.addColumn('number', 'Năm');
        dataTable.addColumn('number', 'Số lượng');

        var yearQuantityMap = {}; // Sử dụng một đối tượng để lưu số lượng tour của từng năm

        // Tính số lượng tour của từng năm
        for (var i = 0; i < data.length; i++) {
            var year = data[i][4];
            var quantity = data[i][5];

            if (yearQuantityMap[year]) {
                yearQuantityMap[year] += quantity;
            } else {
                yearQuantityMap[year] = quantity;
            }
        }

        // Thêm dữ liệu từ đối tượng vào DataTable
        for (var year in yearQuantityMap) {
            dataTable.addRow([parseInt(year), yearQuantityMap[year]]);
        }

        var options = {
            title: 'Biểu đồ thống kê số lượng tour theo năm',
            width: '1100',
            height: '500',
            hAxis: {title: 'Năm', ticks: [2021, 2022, 2023, 2024], format: '####'},
            vAxis: {title: 'Số lượng'},
            bars: 'vertical'
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_tour'));
        chart.draw(dataTable, options);
    }

    function updateTourChart() {
        var selectedYearTour = document.getElementById('yearSelectTour').value;
        loadTourCountData(selectedYearTour);
    }

    function updateTourQuarterChart() {
        var selectedYearTour = document.getElementById('yearSelectTour').value;
        loadTourQuarterData(selectedYearTour);
    }

    function updateTourYearChart() {
        loadTourYearData();
    }

</script>