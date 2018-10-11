package com.example.mc.assignment3_mc;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mc.assignment3_mc.dummy.DummyContent;
import com.example.mc.assignment3_mc.dummy.DummyContent.DummyItem;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class QuizItemFragment extends Fragment implements MyQuizItemRecyclerViewAdapter.InterfaceListener{


    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    //private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    RecyclerView rv;
    MyQuizItemRecyclerViewAdapter adapter;
    ResponseDatabase rdb;
    Button submitbtn;

    public QuizItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")


    public void interfacedisplay(QuizQuestion q)
    {
        QuestionDisplayFragment qd = new QuestionDisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Question",q.question_number+"");
        bundle.putString("Ques",q.question);
        bundle.putSerializable("Database",rdb);
        qd.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout, qd);
        ft.addToBackStack(null);
        ft.commit();


    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quizitem_list, container, false);
        //submitbtn = (Button)view.findViewById(R.id.submitbutton);
//        submitbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new UploadFileAsync().execute("");
//            }
//        });
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
             rv = (RecyclerView) view.findViewById(R.id.list);
            if (mColumnCount <= 1) {
                rv.setLayoutManager(new LinearLayoutManager(context));
            } else {
                rv.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            rdb = new ResponseDatabase(getActivity());
            ArrayList<QuizQuestion> arr = rdb.getQuiz_arr();

            //MyQuizItemRecyclerViewAdapter adapter =
            adapter = new MyQuizItemRecyclerViewAdapter(arr);
            adapter.setInterfaceListner(this);
            rv.setAdapter(adapter);
        }
        return view;
    }


//    @Override
////    public void onAttach(Context context) {
////        super.onAttach(context);
////        if (context instanceof OnListFragmentInteractionListener) {
////            mListener = (OnListFragmentInteractionListener) context;
////        } else {
////            throw new RuntimeException(context.toString()
////                    + " must implement OnListFragmentInteractionListener");
////        }
////    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onListFragmentInteraction(DummyItem item);
//    }


    //new UploadFileAsync().execute("");



//    private class UploadFileAsync extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//
//            try {
//                String sourceFileUri = "responses.csv";
//
//                HttpURLConnection conn = null;
//                DataOutputStream dos = null;
//                String lineEnd = "\r\n";
//                String twoHyphens = "--";
//                String boundary = "*****";
//                int bytesRead, bytesAvailable, bufferSize;
//                byte[] buffer;
//                int maxBufferSize = 1 * 1024 * 1024;
//                File sourceFile = new File(sourceFileUri);
//
//                if (sourceFile.isFile()) {
//
//                    try {
//                        String upLoadServerUri = "http://192.168.59.163/upload.php";
//
//                        // open a URL connection to the Servlet
//                        FileInputStream fileInputStream = new FileInputStream(
//                                sourceFile);
//                        URL url = new URL(upLoadServerUri);
//
//                        // Open a HTTP connection to the URL
//                        conn = (HttpURLConnection) url.openConnection();
//                        conn.setDoInput(true); // Allow Inputs
//                        conn.setDoOutput(true); // Allow Outputs
//                        conn.setUseCaches(false); // Don't use a Cached Copy
//                        conn.setRequestMethod("POST");
//                        conn.setRequestProperty("Connection", "Keep-Alive");
//                        conn.setRequestProperty("ENCTYPE",
//                                "multipart/form-data");
//                        conn.setRequestProperty("Content-Type",
//                                "multipart/form-data;boundary=" + boundary);
//                        conn.setRequestProperty("fileToUpload", sourceFileUri);
//
//                        dos = new DataOutputStream(conn.getOutputStream());
//
//                        dos.writeBytes(twoHyphens + boundary + lineEnd);
//                        dos.writeBytes("Content-Disposition: form-data; name=\"bill\";filename=\""
//                                + sourceFileUri + "\"" + lineEnd);
//
//                        dos.writeBytes(lineEnd);
//
//                        // create a buffer of maximum size
//                        bytesAvailable = fileInputStream.available();
//
//                        bufferSize = Math.min(bytesAvailable, maxBufferSize);
//                        buffer = new byte[bufferSize];
//
//                        // read file and write it into form...
//                        bytesRead = fileInputStream.read(buffer, 0, bufferSize);
//
//                        while (bytesRead > 0) {
//
//                            dos.write(buffer, 0, bufferSize);
//                            bytesAvailable = fileInputStream.available();
//                            bufferSize = Math
//                                    .min(bytesAvailable, maxBufferSize);
//                            bytesRead = fileInputStream.read(buffer, 0,
//                                    bufferSize);
//
//                        }
//
//                        // send multipart form data necesssary after file
//                        // data...
//                        dos.writeBytes(lineEnd);
//                        dos.writeBytes(twoHyphens + boundary + twoHyphens
//                                + lineEnd);
//
//                        // Responses from the server (code and message)
//                        int serverResponseCode = conn.getResponseCode();
//                        String serverResponseMessage = conn
//                                .getResponseMessage();
//
//                        if (serverResponseCode == 200) {
//
//                            // messageText.setText(msg);
//                            //Toast.makeText(ctx, "File Upload Complete.",
//                            //      Toast.LENGTH_SHORT).show();
//
//                            // recursiveDelete(mDirectory1);
//
//                        }
//
//                        // close the streams //
//                        fileInputStream.close();
//                        dos.flush();
//                        dos.close();
//
//                    } catch (Exception e) {
//
//                        // dialog.dismiss();
//                        e.printStackTrace();
//
//                    }
//                    // dialog.dismiss();
//
//                } // End else block
//
//
//            } catch (Exception ex) {
//                // dialog.dismiss();
//
//                ex.printStackTrace();
//            }
//            return "Executed";
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//
//        }
//
//        @Override
//        protected void onPreExecute() {
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//        }
//    }
}
//Citation
// Source : https://stackoverflow.com/questions/25398200/uploading-file-in-php-server-from-android-device