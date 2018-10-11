package com.example.mc.assignment3_mc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.example.mc.assignment3_mc.QuizItemFragment.OnListFragmentInteractionListener;
import com.example.mc.assignment3_mc.dummy.DummyContent.DummyItem;

import java.util.List;


public class MyQuizItemRecyclerViewAdapter extends RecyclerView.Adapter<MyQuizItemRecyclerViewAdapter.ViewHolder> {

    private final List<QuizQuestion> mValues;
    //private final OnListFragmentInteractionListener mListener;

    public interface InterfaceListener
    {
        void interfacedisplay(QuizQuestion ques);
    }

    InterfaceListener interface_listner;

    public void setInterfaceListner (InterfaceListener interlist)
    {
        interface_listner = interlist;
    }

    public MyQuizItemRecyclerViewAdapter(List<QuizQuestion> items) {
        mValues = items;
        //mListener = listener;
    }

    public void onClickFunction(ViewHolder holder)
    {
        if(interface_listner!=null)
        {
            interface_listner.interfacedisplay(holder.mItem);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_quizitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.text.setText("Question:"+holder.mItem.question_number);
        //holder.mIdView.setText(mValues.get(position).id);
        //holder.mContentView.setText(mValues.get(position).content);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        //public final TextView mIdView;
        //public final TextView mContentView;
        public QuizQuestion mItem;
        private TextView text;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            text = (TextView)view.findViewById(R.id.item_number);
            mView.setOnClickListener(this);
           // mIdView = (TextView) view.findViewById(R.id.item_number);
            //mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '"  + "'";
        }

        public void onClick(View v){
            onClickFunction(this);
        }
    }
}
