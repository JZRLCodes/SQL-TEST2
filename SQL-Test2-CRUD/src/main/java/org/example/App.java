package org.example;
import jakarta.persistence.*;

import java.util.Scanner;
import java.io.*;


public class App 
{
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SQL-Test2-CRUD");

    public static void main( String[] args )
    {
        while (true){
                System.out.println("1:   Get Track Price");
                System.out.println("2:   Update Track");
                System.out.println("3:   Add Track");
                System.out.println("4:   Exit");
                System.out.print("Enter your option number: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                if(choice == 1){
                    getTrack();
                }else if(choice == 2){
                    updateTrack();
                }else if(choice == 3){
                    addTrack();
                }else if (choice == 4){
                    System.out.println("Application is terminated");
                    break;
                }else{
                    System.out.println("Wrong input try again.");
                }
        }
        emf.close();
    }
    public static void addTrack()
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;
        try{
            et = em.getTransaction();
            et.begin();

            System.out.println("\n");
            Scanner scanner = new Scanner(System.in);
            //System.out.println("TrackId: ");
            //int trackId = scanner.nextInt();
            System.out.println("Track Name: ");
            String trackName = scanner.nextLine();
            System.out.println("Composer: ");
            String composer = scanner.nextLine();
            System.out.println("Album Id: ");
            int albumId = scanner.nextInt();
            System.out.println("Media Type ID: ");
            int mediaTypeId = scanner.nextInt();
            System.out.println("Genre ID: ");
            int genreId = scanner.nextInt();
            System.out.println("Milliseconds: ");
            int milliseconds = scanner.nextInt();
            System.out.println("Bytes: ");
            int bytes = scanner.nextInt();
            System.out.println("Unit Price: ");
            float unitPrice = scanner.nextFloat();


            Track track = new Track();
            track.setName (trackName);
            track.setAlbumId (albumId);
            track.setMediaTypeId (mediaTypeId);
            track.setGenreId (genreId);
            track.setComposer (composer);
            track.setMilliseconds (milliseconds);
            track.setBytes (bytes);
            track.setUnitPrice (unitPrice);


            em.persist(track);
            et.commit();
        }catch (Exception ex){
            if(et!=null){
                et.rollback();
            }
        }finally {
            em.close();
        }
    }

    public static void updateTrack()
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = null;


        try{
            et = em.getTransaction();
            et.begin();

            System.out.println("\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Track ID: ");
            int id = scanner.nextInt();
            System.out.println("Unit Price: ");
            float unitPrice = scanner.nextFloat();


            if (true) {

                TypedQuery<Track> tq = em.createQuery("select e from Track e where e.trackId=:id", Track.class);
                tq.setParameter("id", id);

                Track track = tq.getSingleResult();
                track.setUnitPrice(unitPrice);

                System.out.println("\n ****************************"+
                        "\nTrack ID: " + track.getTrackId() +
                        "\nNew Price: "+ track.getUnitPrice()+
                        "\n ****************************"+ "\n" + "\n");

                em.persist(track);
                et.commit();
            }
            else {
                System.out.println("Track ID not FOUND");
            }

        }catch(Exception ex){
            if(et!=null){
                et.rollback();
            }
            ex.printStackTrace();

        }finally {
            {
                em.close();
            }
        }
    }

    public static void getTrack()
    {
        EntityManager em = emf.createEntityManager();
        try{
            System.out.println("\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Track ID: ");
            //String id = scanner.nextLine();
            int id = scanner.nextInt();

            if (true) {

                TypedQuery<Track> tq = em.createQuery("select e from Track e where e.trackId=:id", Track.class);
                tq.setParameter("id", id);

                Track track = tq.getSingleResult();

                System.out.println("\n ****************************"+
                        "\nTrack ID: " + track.getTrackId() +
                        "\nTrack Name: " + track.getName() +
                        "\nUnit Price: "+ track.getUnitPrice()+
                        "\n ****************************"+ "\n" + "\n");
            }
            else {
                System.out.println("Track ID not FOUND");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("\n \n Track ID not FOUND! \n \n");

        }finally {
            {
                em.close();
            }
        }
    }

}
