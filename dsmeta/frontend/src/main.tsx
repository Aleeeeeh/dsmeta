import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'

/// Responsável por renderizar os componentes da nossa tela.
/// ID root do nosso index.html, chama esse arquivo que renderiza nossos arquivos dentro da tag React,StrictMode.
ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
)
