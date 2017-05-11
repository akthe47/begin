<%-- 
    Document   : Acceuil
    Created on : 10 mai 2017, 11:23:02
    Author     : ak47@minduos
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@include file="dashhe1.jsp" %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {

        var button = document.getElementById('change-chart');
        var chartDiv = document.getElementById('chart_div');

        var data = google.visualization.arrayToDataTable([
          ['Mois', 'Paiements', 'Factures'],
          ['Janvier', ${montantp1}, ${montantf1}],
          ['Fevrier' , ${montantp2}, ${montantf2}],
          ['Mars', ${montantp3}, ${montantf3}],
          ['Avril' , ${montantp4}, ${montantf4}],
          ['Mai' , ${montantp5}, ${montantf5}],
          ['Juin' , ${montantp6}, ${montantf6}],
          ['Juillet' , ${montantp7}, ${montantf7}],
          ['Aout' , ${montantp8}, ${montantf8}],
          ['Septembre' , ${montantp9}, ${montantf9}],
          ['Octobre' , ${montantp10}, ${montantf10}],
          ['Novembre' , ${montantp11}, ${montantf11}],
          ['Decembre' , ${montantp12}, ${montantf12}],
          
        ]);

        var materialOptions = {
          width: 900,
          chart: {
            title: 'Paiements VS Factures',
            subtitle: 'Paiements en gauche, Factures droite'
          },
          series: {
            0: { axis: 'Paiements' }, // Bind series 0 to an axis named 'distance'.
            1: { axis: 'Factures' } // Bind series 1 to an axis named 'brightness'.
          },
          axes: {
            y: {
              Paiements: {label: 'parsecs'}, // Left y-axis.
              Factures: {side: 'right', label: 'apparent magnitude'} // Right y-axis.
            }
          }
        };

        var classicOptions = {
          width: 900,
          series: {
            0: {targetAxisIndex: 0},
            1: {targetAxisIndex: 1}
          },
          title: 'Nearby galaxies - distance on the left, brightness on the right',
          vAxes: {
            // Adds titles to each axis.
            0: {title: 'parsecs'},
            1: {title: 'apparent magnitude'}
          }
        };

        function drawMaterialChart() {
          var materialChart = new google.charts.Bar(chartDiv);
          materialChart.draw(data, google.charts.Bar.convertOptions(materialOptions));
          button.innerText = 'Change to Classic';
          button.onclick = drawClassicChart;
        }

        function drawClassicChart() {
          var classicChart = new google.visualization.ColumnChart(chartDiv);
          classicChart.draw(data, classicOptions);
          button.innerText = 'Change to Material';
          button.onclick = drawMaterialChart;
        }

        drawMaterialChart();
    };
    </script>
  </head>
  <body>
  <!-- START PAGE CONTAINER -->
        <div class="page-container">
            
            <!-- START PAGE SIDEBAR -->
            <div class="page-sidebar">
                <!-- START X-NAVIGATION -->
                                <ul class="x-navigation">
                    <li class="xn-logo">
                        <a href="">CNA</a>
                        <a href="#" class="x-navigation-control"></a>
                    </li>
                    
                    <li class="xn-title"><center>Navigation</center></li>   
                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							<li>
							<a href="<c:url value='/listcl' />"><span class="fa fa-user"></span><span class="xn-text">Clients</span></a>
							</li>
                                                        </sec:authorize>
                                                        
                            <li class="xn-openable">
                                <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Projets</span></a>
                                <ul>
                            <li><a href="<c:url value='/listpr' />"><span class="fa fa-image"></span> Consulter et Gérer</a></li>
                            <!--<li><a href="pages-invoice.html"><span class="fa fa-dollar"></span> Statistics</a></li>-->
                                                        
                                </ul>
					</li>
                                        <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
					<li class="xn-openable">
						<a href="#"><span class="glyphicon glyphicon-book"></span> <span class="xn-text">Contrats</span></a>
						<ul>	
							<li><a href="<c:url value='/viewcparpr' />"><span class="glyphicon glyphicon-book"></span>Contrats d'honoraires</a></li>
							<li><a href="<c:url value='/viewbcparpr' />"><span class="glyphicon glyphicon-bold"></span>Bon de commandes</a></li>
							<li><a href="<c:url value='/listpr' />"><span class="fa fa-font"></span>Avenant</a></li>
						</ul>
					</li>
                                        </sec:authorize>
                                        <sec:authorize access="hasRole('ADMIN')">
					<li class="xn-openable">
						<a href="#"><span class="fa fa-clipboard"></span> <span class="xn-text">Facturations</span></a>
						<ul>	
							<li><a href="<c:url value='/viewmparpr' />"><span class="fa fa-clipboard"></span>Mémoires d'honoraires</a></li>
							<li><a href="<c:url value='/viewfparpr' />"><span class="fa fa-clipboard"></span>Factures</a></li>
						</ul>
					</li>
                                        
					<li class="xn-openable">
						<a href="#"><span class="fa fa-usd"></span> <span class="xn-text">Réglements</span></a>
						<ul>	
							<li><a href="<c:url value='/listpay' />"><span class="fa fa-usd"></span>Payements</a></li>
							<!--<li><a href="templateclients.html"><span class="fa fa-sign-in"></span>Retenus à la sources</a></li>-->
						</ul>
					</li>
					<!--<li class="xn-openable">
                                <a href="#"><span class="fa fa-envelope"></span><span class="xn-text"> Les bordereaux d'envois</span></a>
                                <ul>
									<li><a href="pages-mailbox-compose.html"><span class="fa fa-pencil"></span> Créer envoi</a></li>
                                    <li><a href="pages-mailbox-inbox.html"><span class="fa fa-inbox"></span> Bordereaux envoyés</a></li> 
                                </ul>
                    </li>-->
                                        
					<li class="xn-openable">
                                <a href="#"><span class="fa fa-key"></span><span class="xn-text"> Gestion des comptes</span></a>
                                <ul>
                                    <li><a href="<c:url value='/list' />"><span class="fa fa-inbox"></span> Utilistaeurs</a></li> 
                                </ul>
                                
                    </li>
					<li class="xn-openable active">
                                <a href="#"><span class="fa fa-wrench"></span><span class="xn-text"> Options</span></a>
                                <ul>
                                    <li><a href="pages-mailbox-inbox.html"><span class="fa fa-inbox"></span> Page de garde</a></li> 
                                </ul>
                    </li>
					<li class="xn-openable">
                                <a href="#"><span class="fa fa-bar-chart-o"></span><span class="xn-text"> Statistics</span></a>
                                <ul>
                                    <li><a href="pages-mailbox-inbox.html"><span class="fa fa-inbox"></span> par ?</a></li> 
                                </ul>
                    </li>
                    </sec:authorize>
                </ul>  
                <!-- END X-NAVIGATION -->
            </div>
            <!-- END PAGE SIDEBAR -->
            
            <!-- PAGE CONTENT -->
            <div class="page-content">
                
               <!-- START X-NAVIGATION VERTICAL -->
                <ul class="x-navigation x-navigation-horizontal x-navigation-panel">
                    <!-- TOGGLE NAVIGATION -->
                    <li class="xn-icon-button">
                        <a href="#" class="x-navigation-minimize"><span class="fa fa-dedent"></span></a>
                    </li>
                    <!-- END TOGGLE NAVIGATION -->
                    <!-- SEARCH 
                    <li class="xn-search">
                        <form role="form">
                            <input type="text" name="search" placeholder="Search..."/>
                        </form>
                    </li>   -->
                    <!-- END SEARCH -->
                    <!-- POWER OFF -->
                    <li class="xn-icon-button pull-right last">
                        <a href="#"><span class="fa fa-power-off"></span></a>
                        <ul class="xn-drop-left animated zoomIn">
                            <li><a href="pages-lock-screen.html"><span class="fa fa-lock"></span> Lock Screen</a></li>
                            <li><a href="#" class="mb-control" data-box="#mb-signout"><span class="fa fa-sign-out"></span> Sign Out</a></li>
                        </ul>                        
                    </li> 
                    <!-- END POWER OFF -->
                    <!-- MESSAGES -->
                    <sec:authorize access="hasRole('ADMIN')">
                    <li class="xn-icon-button pull-right">
                        <a href="#"><span class="fa fa-comments"></span></a>
                        <div class="informer informer-danger">R</div>
                        <div class="panel panel-primary animated zoomIn xn-drop-left xn-panel-dragging">
                            <div class="panel-heading">
                                <h3 class="panel-title"><span class="fa fa-comments"></span> Messages</h3>                                
                                <div class="pull-right">
                                    <span class="label label-danger">4 new</span>
                                </div>
                            </div>
                            <div class="panel-body list-group list-group-contacts scroll" style="height: 200px;">
                                <a href="#" class="list-group-item">
                                    <div class="list-group-status status-online"></div>
                                    <img src="assets/images/users/user2.jpg" class="pull-left" alt="John Doe"/>
                                    <span class="contacts-title">John Doe</span>
                                    <p>Praesent placerat tellus id augue condimentum</p>
                                </a>
                            </div>     
                            <div class="panel-footer text-center">
                                <a href="pages-messages.html">Show all messages</a>
                            </div>                            
                        </div>                        
                    </li>
                    <!-- END MESSAGES -->
                    <!-- TASKS -->
                    <li class="xn-icon-button pull-right">
                        <a href="#"><span class="fa fa-tasks"></span></a>
                        <div class="informer informer-warning">R</div>
                        <div class="panel panel-primary animated zoomIn xn-drop-left xn-panel-dragging">
                            <div class="panel-heading">
                                <h3 class="panel-title"><span class="fa fa-tasks"></span> Tasks</h3>                                
                                <div class="pull-right">
                                    <span class="label label-warning">3 active</span>
                                </div>
                            </div>
                            <div class="panel-body list-group scroll" style="height: 200px;">                                
                                <a class="list-group-item" href="#">
                                    <strong>Phasellus augue arcu, elementum</strong>
                                    <div class="progress progress-small progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">50%</div>
                                    </div>
                                    <small class="text-muted">John Doe, 25 Sep 2015 / 50%</small>
                                </a>
                                <a class="list-group-item" href="#">
                                    <strong>Aenean ac cursus</strong>
                                    <div class="progress progress-small progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">80%</div>
                                    </div>
                                    <small class="text-muted">Dmitry Ivaniuk, 24 Sep 2015 / 80%</small>
                                </a>
                                <a class="list-group-item" href="#">
                                    <strong>Lorem ipsum dolor</strong>
                                    <div class="progress progress-small progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="95" aria-valuemin="0" aria-valuemax="100" style="width: 95%;">95%</div>
                                    </div>
                                    <small class="text-muted">John Doe, 23 Sep 2015 / 95%</small>
                                </a>
                                <a class="list-group-item" href="#">
                                    <strong>Cras suscipit ac quam at tincidunt.</strong>
                                    <div class="progress progress-small">
                                        <div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">100%</div>
                                    </div>
                                    <small class="text-muted">John Doe, 21 Sep 2015 /</small><small class="text-success"> Done</small>
                                </a>                                
                            </div>     
                            <div class="panel-footer text-center">
                                <a href="pages-tasks.html">Show all tasks</a>
                            </div>                            
                        </div>                        
                    </li>
                    </sec:authorize>
                    <!-- END TASKS -->
                    
                </ul>
                <!-- END X-NAVIGATION VERTICAL -->
                <ul class="breadcrumb">
                    <li><a href="#" class="active">Home</a></li>
                </ul>
                <!-- END BREADCRUMB -->
                
                <!-- PAGE CONTENT WRAPPER -->
                <span></span>
                <div class="page-content-wrap">
                    <div class="row">
                        
                            
                            <div class="col-md-3">
                            
                            <!-- START WIDGET CLOCK -->
                            <div class="widget widget-danger widget-padding-sm">
                                <div class="widget-big-int plugin-clock">00:00</div>                            
                                <div class="widget-subtitle plugin-date">Loading...</div>
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="left" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>                            
                                <div class="widget-buttons widget-c3">
                                    <div class="col">
                                        <a href="#"><span class="fa fa-clock-o"></span></a>
                                    </div>
                                    <div class="col">
                                        <a href="#"><span class="fa fa-bell"></span></a>
                                    </div>
                                    <div class="col">
                                        <a href="#"><span class="fa fa-calendar"></span></a>
                                    </div>
                                </div>                            
                            </div>
                            
                        </div>
                        <div class="col-md-3">
                            
                            <!-- START WIDGET MESSAGES -->
                            <div class="widget widget-default widget-item-icon" onclick="location.href='pages-messages.html';">
                                <div class="widget-item-left">
                                    <span class="fa fa-envelope"></span>
                                </div>                             
                                <div class="widget-data">
                                    <div class="widget-int num-count">48</div>
                                    <div class="widget-title">New messages</div>
                                    <div class="widget-subtitle">In your mailbox</div>
                                </div>      
                                <div class="widget-controls">                                
                                    <a href="#" class="widget-control-right widget-remove" data-toggle="tooltip" data-placement="top" title="Remove Widget"><span class="fa fa-times"></span></a>
                                </div>
                            </div>                            
                            <!-- END WIDGET MESSAGES -->
                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <sec:authorize access="hasRole('ADMIN')">
                            <!-- START USERS ACTIVITY BLOCK -->
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="panel-title-box">
                                        <h3>Activité financiére</h3>
                                        <span>Paiements vs Factures</span>
                                    </div>                                    
                                    <ul class="panel-controls" style="margin-top: 2px;">
                                        <li><a href="#" class="panel-fullscreen"><span class="fa fa-expand"></span></a></li>
                                        <li><a href="#" class="panel-refresh"><span class="fa fa-refresh"></span></a></li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="fa fa-cog"></span></a>                                        
                                            <ul class="dropdown-menu">
                                                <li><a href="#" class="panel-collapse"><span class="fa fa-angle-down"></span> Collapse</a></li>
                                                <li><a href="#" class="panel-remove"><span class="fa fa-times"></span> Remove</a></li>
                                            </ul>                                        
                                        </li>                                        
                                    </ul>                                    
                                </div>                                
                                <div class="panel-body padding-0">
                            <div id="chart_div"  style="width: 700px; height: 400px;"></div>
                        </div>                                    
                            </div>
                            </sec:authorize>
                    </div>
                </div>
                </div>
<%@include file="dashf.jsp" %>
<%@include file="dashfe.jsp" %>
