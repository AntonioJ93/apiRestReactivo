
function ListaPersonas({personas}){

    return (
      <div>     
          {
           personas.map(p=>
           <p key={p.id} >id= {p.id} nombre= {p.nombre} edad= {p.edad}</p>
                        )
          }
      </div>
    );
  
}
export default ListaPersonas;