import axios from 'axios';
import icon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import './styles.css'

/// Props são como parâmetros de função no React
type Props = {
    saleId: number;
}
// Função que envia a requisição para chamada da API de SMS
function handleClick(id : number){
    axios(`${BASE_URL}/sales/${id}/notification`)
        .then(response => {
            console.log("SUCESSO")
        })
}

function NotificationButton({saleId} : Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => {handleClick(saleId)}}>
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton
