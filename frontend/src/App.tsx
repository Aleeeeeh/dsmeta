import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Header from './components/Header'
import SalesCard from "./components/SalesCard"

function App() {
  return (
    /// <> São fragments para inserirmos mais de um elemento filho, ou seja usamos quando queremos 
    /// colocar mais de uma tag no mesmo return</>
    <>
      <ToastContainer />
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />
          </div>
        </section>
      </main>
    </>
  )
}

export default App
