package model;

public interface ListVisite<T>  {

public void setVisites(int id_patient, String medecin, int id_salle, String dateVisite);

public T getVisites();

}
