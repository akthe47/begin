            
              </div>    
            <!-- END PAGE CONTENT -->
        </div>
        <!-- END PAGE CONTAINER -->       
        
        <!-- MESSAGE BOX-->
        <div class="message-box animated fadeIn" data-sound="alert" id="mb-signout">
            <div class="mb-container">
                <div class="mb-middle">
                    <div class="mb-title"><span class="fa fa-sign-out"></span> se <strong>Déconnecter</strong> ?</div>
                    <div class="mb-content">
                        <p>vous êtes sûr(e) ?</p>                    
                        <p>Cliquez Non si vous voulez continuer. Cliquez Oui si vous voulez se déconnécter</p>
                    </div>
                    <div class="mb-footer">
                        <div class="pull-right">
                            <a href="<c:url value='/logout' />" class="btn btn-success btn-lg">Oui</a>
                            <button class="btn btn-default btn-lg mb-control-close">Non</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END MESSAGE BOX-->

        <!-- START PRELOADS -->
        <audio id="audio-alert" src="<c:url value='/audio/alert.mp3' />" preload="auto"></audio>
        <audio id="audio-fail" src="<c:url value='/audio/fail.mp3' />" preload="auto"></audio>
        <!-- END PRELOADS -->                       
        
    <!-- START SCRIPTS -->
        <!-- START PLUGINS -->
        <script type="text/javascript" src='<c:url value="/js/plugins/jquery/jquery.min.js" />'></script>
        <script type="text/javascript" src='<c:url value="/js/plugins/jquery/jquery-ui.min.js" />'></script>
        <script type="text/javascript" src='<c:url value="/js/plugins/bootstrap/bootstrap.min.js" />'></script>        
        <!-- END PLUGINS -->                

        <!-- THIS PAGE PLUGINS -->
        <script type='text/javascript' src='<c:url value="/js/plugins/icheck/icheck.min.js" />'></script>
        <script type="text/javascript" src='<c:url value="/js/plugins/mcustomscrollbar/jquery.mCustomScrollbar.min.js" />'></script>
        
        <script type="text/javascript" src='<c:url value="/js/plugins/datatables/jquery.dataTables.min.js" />'></script>
        
        <script type='text/javascript' src='<c:url value="/js/plugins/bootstrap/bootstrap-datepicker.js" />'></script>        
        <script type='text/javascript' src='<c:url value="/js/plugins/bootstrap/bootstrap-select.js" />'></script>        

        <script type='text/javascript' src='<c:url value="/js/plugins/validationengine/languages/jquery.validationEngine-en.js" />'></script>
        <script type='text/javascript' src='<c:url value="/js/plugins/validationengine/jquery.validationEngine.js" />'></script>        

        <script type='text/javascript' src='<c:url value="/js/plugins/jquery-validation/jquery.validate.js" />'></script>                

        <script type='text/javascript' src='<c:url value="/js/plugins/maskedinput/jquery.maskedinput.min.js" />'></script>
		

        <script type="text/javascript" src='<c:url value="/js/plugins/bootstrap/bootstrap-timepicker.min." />'></script>
        <script type="text/javascript" src='<c:url value="/js/plugins/bootstrap/bootstrap-file-input.js" />'></script>

        <script type="text/javascript" src='<c:url value="/js/plugins/tagsinput/jquery.tagsinput.min.js" />'></script>
        <!-- END PAGE PLUGINS -->

        <!-- START TEMPLATE -->
         <script type="text/javascript" src='<c:url value="js/settings.js" />'></script> 
        
        <script type="text/javascript" src='<c:url value="/js/plugins.js" />'></script>        
        <script type="text/javascript" src='<c:url value="/js/actions.js" />'></script>        
        <!-- END TEMPLATE -->
    <!-- END SCRIPTS -->        
    </body>
</html>
