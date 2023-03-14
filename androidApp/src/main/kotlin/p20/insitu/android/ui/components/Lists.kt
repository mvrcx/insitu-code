package p20.insitu.android.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import p20.insitu.android.ui.components.buttons.Buttons
import p20.insitu.android.ui.components.dimen.Padding
import p20.insitu.catalogues.CatalogCategory
import p20.insitu.catalogues.CatalogCategoryGroup
import p20.insitu.catalogues.CatalogSubCategory
import p20.insitu.model.entities.*
import p20.insitu.resources.Language
import p20.insitu.resources.icons.Icons
import p20.insitu.resources.strings.CatalogStrings
import p20.insitu.resources.strings.IconContentDescriptions
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.android.ui.components.dragdrop.DraggableItem
import p20.insitu.android.ui.components.dragdrop.rememberDragDropState

object Lists {

    @Composable
    fun CriminalOffenses(
        list: State<List<CriminalOffense>?>,
        language: Language,
        onClickAction: (item: CriminalOffense) -> Unit
    ) {
        list.value?.let { items ->
            Box {
                val listState = rememberLazyListState()
                val coroutineScope = rememberCoroutineScope()
                LazyColumn(
                    state = listState,
                    contentPadding = PaddingValues(bottom = Padding.listBottom),
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(all = Padding.screen),
                    verticalArrangement = Arrangement.spacedBy(Padding.small)
                ) {
                    items(items = items) { item ->
                        Cards.CriminalOffense(
                            criminalOffense = item,
                            language = language
                        ) {
                            onClickAction(item)
                        }
                    }
                }

                val showScrollToTopButton = listState.firstVisibleItemIndex > 0
                AnimatedVisibility(
                    visible = showScrollToTopButton,
                    enter = fadeIn(),
                    exit = fadeOut(),
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Buttons.ScrollToTop {
                        coroutineScope.launch {
                            listState.scrollToItem(0)
                        }
                    }
                }
            }
        } ?: run {
            LoadingAnimations.StandardLoadingAnimation()
        }
    }

    @Composable
    fun Investigations(
        items: List<Investigation>,
        language: Language,
        onClickAction: (item: Investigation) -> Unit
    ) {
        Box {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.spacedBy(Padding.small)
            ) {
                items(items = items) { item ->
                    Cards.Investigation(
                        docuModeActive = false,
                        investigation = item,
                        language = language
                    ) {
                        onClickAction(item)
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun CrimeScenes(
        items: List<Pair<CrimeScene, Address?>>,
        language: Language,
        onClickAction: (item: CrimeScene) -> Unit
    ) {
        Box {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.spacedBy(Padding.small)
            ) {
                items(items = items) { item ->
                    Cards.CrimeScene(
                        docuModeActive = false,
                        crimeScene = item.first,
                        address = item.second,
                        language = language
                    ) {
                        onClickAction(item.first)
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun DocNumberObjects(
        items: List<DocNumberObject>,
        uiStateHandler: UiStateHandler,
        onStartEditing: () -> Unit,
        onSwap: (Int, Int) -> Unit,
        onStopEditing: () -> Unit,
        onClickAction: (item: DocNumberObject) -> Unit
    ) {
        val language = uiStateHandler.language.collectAsState().value
        var overscrollJob by remember { mutableStateOf<Job?>(null) }
        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()
        val dragDropState = rememberDragDropState(listState) { fromIndex, toIndex ->
            onSwap(fromIndex, toIndex)
        }

        Box {
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                verticalArrangement = Arrangement.spacedBy(Padding.small),
                modifier = Modifier
                    .pointerInput(dragDropState) {
                        detectDragGesturesAfterLongPress(
                            onDrag = { change, offset ->
                                change.consume()
                                dragDropState.onDrag(offset = offset)

                                if (overscrollJob?.isActive == true)
                                    return@detectDragGesturesAfterLongPress

                                dragDropState
                                    .checkForOverScroll()
                                    .takeIf { it != 0f }
                                    ?.let {
                                        overscrollJob =
                                            scope.launch {
                                                dragDropState.state.animateScrollBy(
                                                    it * 1.3f, tween(easing = FastOutLinearInEasing)
                                                )
                                            }
                                    }
                                    ?: run { overscrollJob?.cancel() }
                            },
                            onDragStart = { offset ->
                                onStartEditing()
                                dragDropState.onDragStart(offset)
                            },
                            onDragEnd = {
                                dragDropState.onDragInterrupted()
                                overscrollJob?.cancel()
                                onStopEditing()
                            },
                            onDragCancel = {
                                dragDropState.onDragInterrupted()
                                overscrollJob?.cancel()
                                onStopEditing()
                            }
                        )
                    }
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen)
            ) {
                itemsIndexed(items = items) { index, item ->
                    DraggableItem(
                        dragDropState = dragDropState,
                        index = index
                    ) { isDragging ->
                        val elevation by animateDpAsState(if (isDragging) 4.dp else 0.dp)
                        when {
                            item is Evidence && (item as? Evidence)?.evidenceData != null -> {
                                Cards.SecuredEvidenceDocItem(
                                    evidence = item,
                                    elevation = elevation,
                                    language = language
                                ) {
                                    onClickAction(item)
                                }
                            }
                            item is Site -> {
                                Cards.SiteDocItem(
                                    site = item,
                                    elevation = elevation,
                                    language = language
                                ) {
                                    onClickAction(item)
                                }
                            }
                            else -> {
                                Cards.UnsecuredObjectDocItem(
                                    obj = item,
                                    elevation = elevation,
                                    language = language
                                ) {
                                    onClickAction(item)
                                }
                            }
                        }
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    scope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun Persons(
        items: List<Person>,
        language: Language,
        onClickAction: (person: Person) -> Unit
    ) {
        Box {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.spacedBy(Padding.small)
            ) {
                items(items = items) { item ->
                    Cards.Person(
                        person = item,
                        language = language
                    ) {
                        onClickAction(item)
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun Notes(
        items: List<Note>,
        language: Language,
        onClickAction: (note: Note) -> Unit
    ) {
        Box {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.spacedBy(Padding.small)
            ) {
                items(items = items) { item ->
                    Cards.Note(
                        note = item,
                        language = language
                    ) {
                        onClickAction(item)
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun Audio(
        items: List<Audio>,
        language: Language,
        onClickAction: (audio: Audio) -> Unit
    ) {
        Box {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.spacedBy(Padding.small)
            ) {
                items(items = items) { item ->
                    Cards.Audio(
                        audio = item,
                        language = language
                    ) {
                        onClickAction(item)
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun CatalogCategoryGroups(
        list: List<CatalogCategoryGroup>,
        language: Language,
        onClickAction: (CatalogCategoryGroup) -> Unit
    ) {
        Box {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.spacedBy(Padding.small)
            ) {
                items(items = list) {
                    Cards.CatalogCategoryCard(
                        designation = CatalogStrings.categoryGroup(it, language),
                        imageVector = Icons.catalogCategoryGroup(it),
                        contentDescription = IconContentDescriptions.catalogCategoryGroup(
                            it,
                            language
                        ),
                    ) {
                        onClickAction(it)
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun CatalogCategories(
        list: List<CatalogCategory>,
        language: Language,
        onClickAction: (CatalogCategory) -> Unit
    ) {
        Box {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.spacedBy(Padding.small)
            ) {
                items(items = list) {
                    Cards.CatalogCategoryCard(
                        designation = CatalogStrings.category(it, language),
                        imageVector = Icons.catalogCategory(it),
                        contentDescription = IconContentDescriptions.catalogCategory(
                            it,
                            language
                        ),
                    ) {
                        onClickAction(it)
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }

    @Composable
    fun CatalogSubCategories(
        list: List<CatalogSubCategory>,
        language: Language,
        onClickAction: (CatalogSubCategory) -> Unit
    ) {
        Box {
            val listState = rememberLazyListState()
            val coroutineScope = rememberCoroutineScope()
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = Padding.listBottom),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = Padding.screen),
                verticalArrangement = Arrangement.spacedBy(Padding.small)
            ) {
                items(items = list) {
                    Cards.CatalogCategoryCard(
                        designation = CatalogStrings.subCategory(it, language),
                        imageVector = Icons.catalogSubCategory(it),
                        contentDescription = IconContentDescriptions.catalogSubCategory(
                            it,
                            language
                        ),
                    ) {
                        onClickAction(it)
                    }
                }
            }

            val showScrollToTopButton = listState.firstVisibleItemIndex > 0
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Buttons.ScrollToTop {
                    coroutineScope.launch {
                        listState.scrollToItem(0)
                    }
                }
            }
        }
    }
}