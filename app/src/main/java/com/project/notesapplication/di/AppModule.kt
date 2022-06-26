package com.project.notesapplication.di

import android.app.Application
import androidx.room.Room
import com.project.notesapplication.feature_note.data.data_source.NoteDataBase
import com.project.notesapplication.feature_note.data.repository.NoteRepositoryImpl
import com.project.notesapplication.feature_note.domain.repository.NoteRepository
import com.project.notesapplication.feature_note.domain.usecases.AddNote
import com.project.notesapplication.feature_note.domain.usecases.DeleteNote
import com.project.notesapplication.feature_note.domain.usecases.GetNotes
import com.project.notesapplication.feature_note.domain.usecases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(context: Application): NoteDataBase {
        return Room.databaseBuilder(context,
            NoteDataBase::class.java,
            NoteDataBase.NOTES_DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun noteRepository(db: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }


}