using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Usuarios
    {

        ArrayList usuarios;

        /**
         * Constructor por defecto de la clase Usuarios
         **/
        public Usuarios()
        {
            this.usuarios = new ArrayList();
            usuarios.Add(new Usuario("Adminstrador", "1q2w3e4r", "ADMINISTRADOR"));
            usuarios.Add(new Usuario("Direccion", "1q2w3e4r", "DIRECCION"));
            usuarios.Add(new Usuario("administrativo", "1q2w3e4r", "ADMINISTRATIVO"));
            usuarios.Add(new Usuario("Personalsanitario", "1q2w3e4r", "PERSONAL"));
        }

        //GETTERS Y SETTERS

        public void setUsuarios(ArrayList usuarios)
        {
            this.usuarios = usuarios;
        }

        public ArrayList getUsuarios()
        {
            return this.usuarios;
        }
    }
}
