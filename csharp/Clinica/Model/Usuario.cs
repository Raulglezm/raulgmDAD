using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{ 
    public class Usuario
    {
        String nick;
        String contrasenia;
        String rol;

        /**
         * Constructor por defecto de la clase 
         **/
        public Usuario(String nick, String contrasenia, String rol)
        {
            this.nick = nick;
            this.contrasenia = contrasenia;
            this.rol = rol;
        }

        //GETTERS Y SETTERS

        public String getNick()
        {
            return nick;
        }

        public void setNick(String nick)
        {
            this.nick = nick;
        }

        public String getContrasenia()
        {
            return contrasenia;
        }

        public void setContrasenia(String contrasenia)
        {
            this.contrasenia = contrasenia;
        }

        public String getRol()
        {
            return rol;
        }
        public void setRol(String rol)
        {
            this.rol = rol;
        }
    }
}
