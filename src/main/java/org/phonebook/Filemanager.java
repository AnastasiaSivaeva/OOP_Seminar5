package org.phonebook;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;

public class Filemanager {

    static String FILE_PATH = "./src/main/java/org/phonebook/";
    String FILE_NAME_EXPORT = "export.csv";
    String FILE_PATH_FULL = FILE_PATH+FILE_NAME_EXPORT;
    public void fileExport(ArrayList<Phonebook> pb){
        Logging.LOGGER.log(Level.INFO,"Запущен экспорт ");
        try(FileWriter writer = new FileWriter(FILE_PATH + FILE_NAME_EXPORT, false))
        {
            // запись всей строки
//            String text = "Hello Gold!";
            for(Phonebook i: pb){
                String text = i.getName()+";"+i.getPhone()+";"+i.getCity();
                writer.write(text);
                // запись по символам
                writer.append('\n');
//                writer.append('E');
            }
            writer.flush();
            Logging.LOGGER.log(Level.FINE,"Файл записан ");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            Logging.LOGGER.log(Level.WARNING,"Ошибка");
        }
    }


    public void fileImport(ArrayList<Phonebook> pb){
        Logging.LOGGER.log(Level.INFO,"Запущен импорт ");
        try {
            File file = new File(FILE_PATH_FULL);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);

                String[] tmp = line.split(";");

                pb.add(new Phonebook(tmp[0], tmp[1], tmp[2]));
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
