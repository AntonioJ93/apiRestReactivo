
import './App.css';
import ListaPersonas from './componentes/ListaPersonas';
import { useEffect, useState } from 'react';
import FormularioAddPersona from './componentes/FormularioAddPersona';
function App() {

const [personas, setPersonas] = useState();
const [error, setError] = useState(null);
const [isLoaded, setIsLoaded] = useState(false);

useEffect(() => {
  fetch("http://localhost:8080/persona/all")
    .then(res => res.json())
    .then(
      (result) => { 
        setIsLoaded(true);
          setPersonas(result);
      },
      
      (error) => {
        setIsLoaded(true);
        setError(error);
      }
    )
}, [])
if (error) {
  return <div>Error: {error.message}</div>;
} else if (!isLoaded) {
  return <div>Loading...</div>;
} else {
  return (

    <div className="App">
      <header className="App-header">
        <FormularioAddPersona/>
        <ListaPersonas personas={personas}/>   
      </header>
    </div>
  );
}



    
}

export default App;
