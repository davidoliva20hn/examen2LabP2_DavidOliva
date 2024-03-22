/*
 */
package examen2labp2_davidoliva;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAVIDANDRESOLIVAHERN
 */
public class AdminCarros implements Serializable {

// Archivos binarios 
    private File Archivos;
    private ArrayList<Carro> ListaCarro = new ArrayList();

    public AdminCarros() {
    }

    public AdminCarros(String pata) {
        this.Archivos = new File(pata);
    }

    public File getArchivos() {
        return Archivos;
    }

    public void setArchivos(File Archivos) {
        this.Archivos = Archivos;
    }

    public ArrayList<Carro> getListaCarro() {
        return ListaCarro;
    }

    public void setListaCarro(ArrayList<Carro> ListaCarro) {
        this.ListaCarro = ListaCarro;
    }

    public void escribirArchivo() {
        try
        {
            FileOutputStream escriturafile = null;
            ObjectOutputStream escritura = null;

            try
            {
                escriturafile = new FileOutputStream(Archivos);
                escritura = new ObjectOutputStream(escriturafile);
                escritura.writeObject(ListaCarro);
            } catch (IOException ex)
            {
                Logger.getLogger(AdminCarros.class.getName()).log(Level.SEVERE, null, ex);
            }
            escriturafile.close();
            escritura.close();
        } catch (IOException ex)
        {
            Logger.getLogger(AdminCarros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void cargarArchivo() {
        try
        {
            FileInputStream Filelectura = null;
            ObjectInputStream lectura = null;
            
            try
            {
                Filelectura = new FileInputStream(Archivos);
                lectura = new ObjectInputStream(Filelectura);
                ListaCarro = (ArrayList<Carro>) (Object) lectura.readObject();
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(AdminCarros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex)
            {
                Logger.getLogger(AdminCarros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(AdminCarros.class.getName()).log(Level.SEVERE, null, ex);
            }
            lectura.close();
            Filelectura.close();
        } catch (IOException ex)
        {
            Logger.getLogger(AdminCarros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
