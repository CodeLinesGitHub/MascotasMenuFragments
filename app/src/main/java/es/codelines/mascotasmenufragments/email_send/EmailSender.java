package es.codelines.mascotasmenufragments.email_send;
import android.os.AsyncTask;

/**
 * Created by edgar on 04/04/2015.
 */
public class EmailSender extends AsyncTask<String,Void,Boolean>   {
    @Override
    protected Boolean doInBackground(String... data) {

        String emailSenderAddress= data[0];
        String emailSenderPassword= data[1];
        String recipients= data[2];
        String subject= data[3];
        String comments= data[4];
        String pictureFileName= data[5];

        Email m = new Email(emailSenderAddress,emailSenderPassword);

        m.setTo(recipients);
        m.setFrom(emailSenderAddress);
        m.setSubject(subject);
        m.setBody(comments);

        try {
            ///m.addAttachment("/sdcard/filelocation");
            m.setPictureFileName(pictureFileName);
            //Log.e("LogsAndroid", "Mensaje de error");
            return m.send();
        }
        catch (Exception e ) {
            //Toast.makeText(MainActivity.this, "There was a problem sending the email." + e.getMessage(), Toast.LENGTH_LONG).show();
            //throw  new Exception("Error sending ")
            throw new RuntimeException("Bang");
            //throw new RuntimeException(e);


        }


    }

    @Override
    protected void onPostExecute(Boolean result) {

    }
}
