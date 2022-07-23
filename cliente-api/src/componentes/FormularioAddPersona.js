import { useEffect, useState } from 'react';
import Axios from "axios";

function FormularioAddPersona() {
    const [persona, setPersona] = useState();
    useEffect(() => {
        console.log("Loading...");
        const fetchData = async (nombre, edad) => {
          try {
            const { data } = await Axios.post(
              "http://localhost:8080/persona",
              {
                nombre,
                edad
              }
            );
            console.log(data);
          } catch (error) {
            console.log(error);
          }
        };
      
        fetchData(
          nombre.value,
          "Bacon ipsum",
          "Bacon ipsum dolor amet drumstick short loin frankfurter beef boudin, tail ball tip venison picanha tongue"
        );
      }, []);
    
    return (
        <>
            <label for="nombre">Nombre
                <input type="text" name="nombre" placeholder="Nombre" id="nombre" />
            </label>
            <label for="edad">Edad
                <input type="number" name="edad" placeholder="Edad" id="edad" />
            </label>
            <button type="submit" onClick={setPersona} >Guardar</button>
        </>
    );
}
export default FormularioAddPersona;