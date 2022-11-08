using Microsoft.Win32;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
{
    public class ClinicaController 
    {
        Model.Usuario user;
        Model.Usuarios usuarios;

        /**
         * Constructor con un parametro de la clase Clinica Controller
         **/
        public ClinicaController (Usuarios usuarios)
        {
            this.usuarios = usuarios;
        }

        /**
         * En este metodo se inicia sesion y se comprueba el rol del usuario
         **/
        public void login(String usuario, String contrasenia)
        { 
            foreach(Usuario user in usuarios.getUsuarios())
            { 
                if(user.getNick().Equals(usuario) && user.getContrasenia().Equals(contrasenia))
                {
                    redirigirVista(user.getRol());
                }
            }    
        }

        /**
         * En este metodo se redirige a la vista según el rol del usuario
         **/
        public void redirigirVista(String rol)
        { 
            switch (rol)
            {
                case "ADMINISTRADOR":
                    break;
                case "DIRECCION":
                    break;
                case "ADMINISTRATIVO":
                    break;
                case "PERSONAL":
                    break;
            }
        }

    }
}
