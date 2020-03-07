package com.amicritas.e_graments.modals;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TitleCreator {
    static TitleCreator _titleCreator;
    List<TitleParent> _titleParents;

    public TitleCreator(Context context) {
        _titleParents = new ArrayList<>();
        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("Mens");
        mylist.add("Womens");
        mylist.add("Mens");
        mylist.add("Womens");
        mylist.add("Other");
        int i;
        for(i=1;i<=mylist.size();i++)
        {
            String s = mylist.get(0);
            Toast.makeText(context, ""+s, Toast.LENGTH_SHORT).show();
            TitleParent title = new TitleParent(String.format(s,1));
            _titleParents.add(title);
        }
        /*TitleParent title = new TitleParent(String.format(String.valueOf(mylist)));
        _titleParents.add(title);*/
    }

    public static TitleCreator get(Context context)
    {
        if(_titleCreator == null)
            _titleCreator = new TitleCreator(context);
        return _titleCreator;
    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}
