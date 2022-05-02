import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';

function App() {

  const [persona, setPersona] = useState();
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);

  useEffect(() => {
    fetch("http://localhost:8080/persona/all")
      .then(res => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setPersona(result[0]);
        },
        // Nota: es importante manejar errores aquí y no en 
        // un bloque catch() para que no interceptemos errores
        // de errores reales en los componentes.
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
          <p>
            Id= ${persona.id} Nombre= ${persona.nombre}.
          </p>
        </header>
      </div>
    );


    {/*
      <ul>
        {items.map(item => (
          <li key={item.id}>
            {item.name} {item.price}
          </li>
        ))}
      </ul>
    );
       */ }
  }


}

export default App;
