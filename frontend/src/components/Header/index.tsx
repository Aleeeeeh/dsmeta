import logo from '../../assets/img/logo.svg'
import './styles.css'

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="DSMeta" />
                <h1>DSMeta</h1>
                <p>
                    Desenvolvido por
                    <a href="https://br.linkedin.com/in/alefe-ferreira-322125235?trk=public_profile_samename-profile">@AlefeSilva</a>
                </p>
            </div>
        </header>
    )
}

export default Header
