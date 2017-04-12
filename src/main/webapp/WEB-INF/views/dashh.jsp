<%-- 
    Document   : dashboard
    Created on : 31 mars 2017, 13:40:48
    Author     : ak47@minduos
--%>




<!DOCTYPE html>
<html lang="en">
    <head>        
        <!-- META SECTION -->
        <title>CNA - Clients</title>            
        
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        
        <link rel="icon" href="favicon.ico" type="<c:url value='/image/x-icon' />" />
        <!-- END META SECTION -->
        
        <!-- CSS INCLUDE -->        
        <link rel="stylesheet" type="text/css" id="theme" href="<c:url value='/css/theme-default.css' />"/>
        <!-- EOF CSS INCLUDE -->                                      
    </head>
    <body>
        <!-- START PAGE CONTAINER -->
        <div class="page-container">
            
            <!-- START PAGE SIDEBAR -->
            <div class="page-sidebar">
                <!-- START X-NAVIGATION -->
                <ul class="x-navigation">
                    <li class="xn-logo">
                        <a href="index.html">CNA</a>
                        <a href="#" class="x-navigation-control"></a>
                    </li>
                    
                    <li class="xn-title"><center>Navigation</center></li>                    
							<li>
							<a href="templateclients.html"><span class="fa fa-user"></span><span class="xn-text">Clients</span></a>
							</li>
                    <li class="xn-openable">
                        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Projets</span></a>
                        <ul>
                            <li><a href="templateprojets.html"><span class="fa fa-image"></span> Consulter et Gérer</a></li>
                            <li><a href="pages-invoice.html"><span class="fa fa-dollar"></span> Statistics</a></li>
                                                        
                        </ul>
					</li>
					<li class="xn-openable">
						<a href="#"><span class="glyphicon glyphicon-book"></span> <span class="xn-text">Contrats</span></a>
						<ul>	
							<li><a href="templatecontrath.html"><span class="glyphicon glyphicon-book"></span>Contrats d'honoraires</a></li>
							<li><a href="templatecontrath.html"><span class="glyphicon glyphicon-bold"></span>Bon de commandes</a></li>
							<li><a href="templatecontrath.html"><span class="fa fa-font"></span>Avenant</a></li>
						</ul>
					</li>
					<li class="xn-openable">
						<a href="#"><span class="fa fa-clipboard"></span> <span class="xn-text">Facturations</span></a>
						<ul>	
							<li><a href="templateclients.html"><span class="fa fa-clipboard"></span>Mémoires d'honoraires</a></li>
							<li><a href="templateclients.html"><span class="fa fa-clipboard"></span>Factures</a></li>
						</ul>
					</li>
					<li class="xn-openable">
						<a href="#"><span class="fa fa-usd"></span> <span class="xn-text">Réglements</span></a>
						<ul>	
							<li><a href="templateclients.html"><span class="fa fa-usd"></span>Payements</a></li>
							<li><a href="templateclients.html"><span class="fa fa-sign-in"></span>Retenus à la sources</a></li>
						</ul>
					</li>
					<li class="xn-openable">
                                <a href="#"><span class="fa fa-envelope"></span><span class="xn-text"> Les bordereaux d'envois</span></a>
                                <ul>
									<li><a href="pages-mailbox-compose.html"><span class="fa fa-pencil"></span> Créer envoi</a></li>
                                    <li><a href="pages-mailbox-inbox.html"><span class="fa fa-inbox"></span> Bordereaux envoyés</a></li> 
                                </ul>
                    </li>
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
                    <!-- SEARCH -->
                    <li class="xn-search">
                        <form role="form">
                            <input type="text" name="search" placeholder="Search..."/>
                        </form>
                    </li>   
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
                    <li class="xn-icon-button pull-right">
                        <a href="#"><span class="fa fa-comments"></span></a>
                        <div class="informer informer-danger">1</div>
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
                        <div class="informer informer-warning">1</div>
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
                    <!-- END TASKS -->
                    
                </ul>
                <!-- END X-NAVIGATION VERTICAL -->

            
