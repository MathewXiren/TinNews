package com.xma.tinnews.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.xma.tinnews.ui.home.HomeViewModel;
import com.xma.tinnews.ui.save.SaveViewModel;
import com.xma.tinnews.ui.search.SearchViewModel;

// factory 新建的viewmodel有生命周期
// provider can mange the memory, helpe save information whwen switch to another app
// when swipe back, grab it back
public class NewsViewModelFactory implements ViewModelProvider.Factory {

    private final NewsRepository repository;

    public NewsViewModelFactory(NewsRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(repository);
        } else if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            return (T) new SearchViewModel(repository);
        } else if (modelClass.isAssignableFrom(SaveViewModel.class)) {
            return (T) new SaveViewModel(repository);

        } else {
            throw new IllegalStateException("Unknown ViewModel");
        }
    }
}
