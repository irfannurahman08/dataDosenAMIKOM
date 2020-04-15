package online.irfandev.datadosenamikom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class listDosenAdapter extends RecyclerView.Adapter<listDosenAdapter.MyHolder>{
    private Context context;
    ArrayList<String> mFoto = new ArrayList<>();
    ArrayList<String> mNama = new ArrayList<>();
    ArrayList<String> mAlamat = new ArrayList<>();
    ArrayList<String> mEmail = new ArrayList<>();

    public listDosenAdapter(Context context, ArrayList<String> mFoto, ArrayList<String> mNama, ArrayList<String> mAlamat, ArrayList<String> mEmail) {
        this.context = context;
        this.mFoto = mFoto;
        this.mNama = mNama;
        this.mAlamat = mAlamat;
        this.mEmail = mEmail;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //memanggil class myHolder
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_dosen,parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        Glide.with(context).asBitmap().load(mFoto.get(position)).into(holder.imagesViewFoto);
        holder.textViewNama.setText(mNama.get(position));
        holder.textViewAlamat.setText(mAlamat.get(position));
        holder.textViewEmail.setText(mEmail.get(position));

        holder.layout_list_dosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mNama.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return mNama.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView imagesViewFoto;
        TextView textViewNama, textViewAlamat,textViewEmail;
        RelativeLayout layout_list_dosen;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagesViewFoto=itemView.findViewById(R.id.imageViewFoto);
            textViewNama=itemView.findViewById(R.id.textViewNama);
            textViewAlamat=itemView.findViewById(R.id.textViewAlamat);
            textViewEmail=itemView.findViewById(R.id.textViewEmail);
            layout_list_dosen=itemView.findViewById(R.id.layout_list_dosen);
        }
    }
}
