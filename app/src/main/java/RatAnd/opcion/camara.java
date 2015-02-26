package RatAnd.opcion;


import android.app.Fragment;
import android.hardware.camera2.CameraDevice;
import android.view.View;

/**
 * Created by Vero on 26/02/2015.
 */
public class camara extends Fragment implements  View.OnClickListener {
    public void onOpened(CameraDevice cameraDevice) {

  // This method is called when the camera is opened.  We start camera preview here.

        mCameraOpenCloseLock.release();

        mCameraDevice = cameraDevice;

        createCameraPreviewSession();

    }

    @Override
    public void onClick(View v) {

    }

}


}

