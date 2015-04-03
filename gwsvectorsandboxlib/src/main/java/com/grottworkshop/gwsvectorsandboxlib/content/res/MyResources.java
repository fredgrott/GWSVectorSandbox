package com.grottworkshop.gwsvectorsandboxlib.content.res;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

import com.grottworkshop.gwsvectorsandboxlib.MyVector;

/**
 * Created by fgrott on 4/3/2015.
 */
public class MyResources extends Resources {
    private final Resources mResources;

    public MyResources(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        mResources = resources;
    }

    public boolean oldFor(Resources superResources) {
        return superResources != mResources;
    }

    @Override
    public Drawable getDrawable(int id) throws NotFoundException {
        Drawable mr = lookup(id);
        if (mr != null) {
            return mr;
        }
        return super.getDrawable(id);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        Drawable mr = lookup(id, density);
        if (mr != null) {
            return mr;
        }
        return super.getDrawableForDensity(id, density);
    }

    @Override
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Drawable getDrawable(int id, Theme theme) throws NotFoundException {
        return super.getDrawable(id, theme);
    }


    @Override
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Drawable getDrawableForDensity(int id, int density, Theme theme) {
        return super.getDrawableForDensity(id, density, theme);
    }

  /* TODO some sorcery to make the calls from TypedArray work

  Drawable loadDrawable(TypedValue value, int id) throws Resources.NotFoundException {
    Log.d("vector", "loadDrawable@2 " + id);
    return super.loadDrawable(value, id);
  }

  Drawable loadDrawable(TypedValue value, int id, Theme theme) throws Resources.NotFoundException {
    Log.d("vector", "loadDrawable@3 " + id);
    return super.loadDrawable(value, id, theme);
  }
  */


    private Drawable lookup(int id) {
        return MyVector.lookup(mResources, id, 0, false);
    }

    private Drawable lookup(int id, int density) {
        return MyVector.lookup(mResources, id, density, true);
    }

}