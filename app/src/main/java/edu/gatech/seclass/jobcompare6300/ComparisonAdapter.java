package edu.gatech.seclass.jobcompare6300;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;
import edu.gatech.seclass.jobcompare6300.Job;



public class ComparisonAdapter extends RecyclerView.Adapter<ComparisonAdapter.ComparisonViewHolder> {


    //1. ComparisonAdapter class


    private Context context;
    private ArrayList<Job> jobs; // import edu.gatech.seclass.jobcompare6300.Job; //consider job with selected bool or consider keep seperatly a list for selected index
    private ArrayList<JobItem> jobItems = new ArrayList<>();

    //constructor
    public ComparisonAdapter(Context context, ArrayList<Job> jobs){
        this.context = context;
        this.jobs = jobs;
        for(Job job : jobs) {
            JobItem jobItem = new JobItem(job);
            jobItems.add(jobItem);
        }
    }


    class JobItem{
        public Job job;
        public boolean checkStatus = false;

        public JobItem(Job job){
            this.job = job;
            this.checkStatus = false;
        }
        public void setChecked(boolean checkstatus){
            checkStatus = checkstatus;
        }

        public boolean isChecked(){
            return checkStatus;
        }

        public String getTitle(){
            return job.getTitle();
        }

        public String getCompany(){
            return job.getCompany();
        }

        public boolean getCurrent(){
            return job.getCurrent();
        }


    }
    //2. ViewHolder class

    class ComparisonViewHolder extends RecyclerView.ViewHolder{
        private TextView textView_title;
        private TextView textView_company;
        private TextView textView_current;
        private CheckBox checkbox;

        //link with items in row_item.xml
        public ComparisonViewHolder(View itemView){
            super(itemView);
            textView_title = itemView.findViewById(R.id.job_title);
            textView_company = itemView.findViewById(R.id.job_company);
            textView_current = itemView.findViewById(R.id.job_current);

            checkbox = itemView.findViewById(R.id.item_checkbox);

        }

        // getting the selected items
        void bind (JobItem jobItem){
//            imageView.setVisibility(job.isChecked ? View.VISIBLE: View.GONE) // todo: job has checked function? maybe need to create a decorator around job to use here
            String title = jobItem.getTitle();
            String company = jobItem.getCompany();
            boolean current = jobItem.getCurrent();
            textView_title.setText(title);
            textView_company.setText(company);
            if (current){
                textView_current.setText("current");
            }
            checkbox.setChecked(false);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    jobItem.setChecked(!jobItem.isChecked()); // todo: setChecked function. set opposite sign for checked after beging clicked
//                }
//            });
            checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    // handle checkbox click event
                    jobItem.setChecked(!jobItem.isChecked());
                }
            });

        }
    }
    public ArrayList<Job> getSelected(){
        ArrayList<Job> selected = new ArrayList<Job>();
         for(JobItem jobItem : jobItems) {
            if (jobItem.isChecked()){
                selected.add(jobItem.job);
            }
         }
         return selected;
    }


    @Override
    public ComparisonViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ComparisonViewHolder(view);
    }

    @Override
    public void onBindViewHolder (ComparisonViewHolder holder, int position){
        holder.bind(jobItems.get(position));
    }


    @Override
    public int getItemCount(){
        return jobItems.size();
    }


    // reference: https://developer.android.com/develop/ui/views/layout/recyclerview
}
