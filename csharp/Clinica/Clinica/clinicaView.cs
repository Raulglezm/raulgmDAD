using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Clinica
{
    public partial class clinicaView : Form
    {

        Controller.ClinicaController clController;

        public clinicaView(Model.Usuarios usuarios)
        {
            InitializeComponent();
            clController = new Controller.ClinicaController(usuarios);
        }

        private void clinicaView_Load(object sender, EventArgs e)
        {

        }

        private void clinicaView_Load_1(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show("hola");
            clController.login(this.txtUsuario.Text.ToString(), this.txtContrasenia.Text.ToString());
        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
