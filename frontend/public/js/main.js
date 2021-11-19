class ElHeader extends HTMLElement{
connectedCallback () {
this.innexHTML = `
<header id="header" class="header shadow">
            <div class="header-inner">


                <div class="logo">
                    <a href="index.html">
                        <img class="logo-light" src="img/LOGO.png" alt="Global Talent House" />
                    </a>
                </div>

                <div class="side-menu-btn">
                    <ul>
                        <li class="">
                            <a class="search-overlay-menu-btn header-icon"><i class="fa fa-search"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="nav-mobile nav-bar-icon">
                    <span></span>
                </div>

                <div class="nav-menu">
                    <ul class="nav-menu-inner">
                        <li>
                            <a class="" href="home.html">Inicio</a>
                        </li>
                        <li>
                            <a class="" href="about-us.html">Sobre Nosotros</a>                         
                        </li>
                        <li>
                            <a class="menu-has-sub">Libros<i class="fa fa-angle-down"></i></a>
							<!-- Dropdown -->
                            <ul class="sub-dropdown dropdown">
								<li>
                                    <a href="artist-directory.html">Libros Virtuales</a>
                                </li>
                                <li>
                                    <a href="institutes-directory.html">Libros Fisicos</a>
                                </li>
                            </ul>

                        </li>
                        <li>
                            <a class="menu-has-sub">Prestamos<i class="fa fa-angle-down"></i></a>
							<!-- Dropdown -->
                            <ul class="sub-dropdown dropdown">
								<li>
                                    <a href="404.html">Normas</a>
                                </li>
                                <li>
                                    <a href="404.html">Calendario</a>
                                </li>
								<li>
                                    <a href="404.html">Multas </a>
                                </li>
                            </ul>
                            <!-- End Dropdown -->
                        </li>
                        <li>
                            <a class="" href="404.html">Contactenos</a>
                        </li>
                        <li>
                            <a class="" href="login.html">Inicia Sesion</a>                            
                        </li>
						<li>
                            <a class="btn btn-md btn-black join-btn" href="404.html">Unete a nosotros</a>                            
                        </li>
                    </ul>
                </div>
 

            </div>
        </header>
`
}
}
customElements.define ( 'ElHeader', ElHeader)
class ElFooter extends HTMLElement{
    connectedCallback () {
    this.innexHTML = `
    <footer class="footer pt-60">
    <div class="container">
        <!--Footer Info -->
        <div class="row footer-info mb-30">
            <div class="col-md-6 col-sm-12 col-xs-12 mb-sm-30 text-sm-left">
                <p class="mb-xs-0">Our ante tincidunt tempus, Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros.</p>
                <ul class="link-small">
                    <li><a href="mailto:yourname@domain.com"><i class="fa fa-envelope-o left"></i>yourname@domain.com</a></li>
                    <li><a><i class="fa fa-phone left"></i>+40 (0) 012 345 6789</a></li>
                </ul>
            </div>
            <div class="col-md-6 col-sm-12 col-xs-12 text-right text-sm-left">
                <ul class="link">
                    <li><a href="privacy-policy.html">Privacy Policy</a></li>
                    <li><a href="terms-and-conditions.html">Terms</a></li>
                    <li><a href="faq.html">FAQ</a></li>
                    <li><a href="contact-us.html">Contact</a></li>
                </ul>
                <div class="spacer-30"></div>
                <ul class="social">
                    <li><a target="_blank" href="https://www.twitter.com/"><i class="fa fa-twitter"></i></a></li>
                    <li><a target="_blank" href="https://instagram.com/"><i class="fa fa-instagram"></i></a></li>
                    <li><a target="_blank" href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a></li>
                    <li><a target="_blank" href="https://youtube.com/"><i class="fa fa-youtube"></i></a></li>
                    <li><a target="_blank" href="https://www.linkedin.com/"><i class="fa fa-linkedin"></i></a></li>
                </ul>
            </div>
        </div>
        <!-- End Footer Info -->
    </div>

    <hr />

    <!-- Copyright Bar -->
    <div class="copyright ptb-15">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 text-left text-sm-left">© 2016 <a href="index.html"><b>Global Talent House</b></a>. All Rights Reserved.</div>
                <div class="col-sm-6 text-right text-sm-left">Website  by <a target="_blank" href="http://vrinmkansal.com/"><b>Vrinda Maru Kansal</b></a></div>
            </div>
        </div>
    </div>
    <!-- End Copyright Bar -->

</footer>
    `
    }
}

customElements.define ( 'ElFooter', ElFooter)