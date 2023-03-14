package p20.insitu.viewmodels

import org.koin.dsl.module
import p20.insitu.getWith
import p20.insitu.viewmodels.documode.*
import p20.insitu.viewmodels.entities.*

val viewModelsModule = module {

    factory {
        ApartmentViewModel(
            getWith(ApartmentViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        AudioViewModel(
            getWith(AudioViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        BuildingViewModel(
            getWith(BuildingViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory { CatalogViewModel(getWith(CatalogViewModel::class.simpleName), get(), get()) }
    factory {
        CrimeSceneViewModel(
            getWith(CrimeSceneViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        CriminalOffenseViewModel(
            getWith(CriminalOffenseViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        DocuPersonsViewModel(
            getWith(DocuPersonsViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        DocuListViewModel(
            getWith(DocuListViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        DNATraceViewModel(
            getWith(PhysicalTraceViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        DoorViewModel(
            getWith(DoorViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        FloorViewModel(
            getWith(FloorViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        ImageViewModel(
            getWith(ImageViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        ImagePagerViewModel(
            getWith(ImagePagerViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        InvestigationListViewModel(
            getWith(InvestigationListViewModel::class.simpleName),
            get(),
            get(),
            get()
        )
    }
    factory {
        InvestigationViewModel(
            getWith(InvestigationViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        NoteViewModel(
            getWith(NoteViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        PersonViewModel(
            getWith(PersonViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        PhysicalTraceViewModel(
            getWith(PhysicalTraceViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        RoomViewModel(
            getWith(RoomViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        SomeObjectViewModel(
            getWith(SomeObjectViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        SomeSiteViewModel(
            getWith(SomeSiteViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    factory {
        StartViewModel(
            getWith(StartViewModel::class.simpleName),
            get(),
            get(),
            get()
        )
    }
    factory {
        VideoViewModel(
            getWith(VideoViewModel::class.simpleName),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
}