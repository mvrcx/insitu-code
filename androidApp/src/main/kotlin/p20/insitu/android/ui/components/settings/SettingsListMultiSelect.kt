package p20.insitu.android.ui.components.settings

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import p20.insitu.db.settings.SettingValueState

@Composable
fun SettingsListMultiSelect(
    modifier: Modifier = Modifier,
    storage: SettingValueState<Set<Int>>,
    title: @Composable () -> Unit,
    items: List<String>,
    icon: @Composable() (() -> Unit)? = null,
    confirmButton: String,
    useSelectedValuesAsSubtitle: Boolean = true,
    subtitle: @Composable() (() -> Unit)? = null,
    action: @Composable() (() -> Unit)? = null,
) {

    if (storage.value.any { index -> index >= items.size }) {
        throw IndexOutOfBoundsException("Current indexes for $title list setting cannot be grater than items size")
    }

    var showDialog by remember { mutableStateOf(false) }

    val safeSubtitle = if (storage.value.size >= 0 && useSelectedValuesAsSubtitle) {
        {
            Text(text = storage.value.map { index -> items[index] }
                .joinToString(separator = ", ") { it })
        }
    } else subtitle

    SettingsMenuLink(
        modifier = modifier,
        icon = icon,
        title = title,
        subtitle = safeSubtitle,
        action = action,
        onClick = { showDialog = true },
    )

    if (!showDialog) return

    val onAdd: (Int) -> Unit = { selectedIndex ->
        val mutable = storage.value.toMutableSet()
        mutable.add(selectedIndex)
        storage.value = mutable
    }
    val onRemove: (Int) -> Unit = { selectedIndex ->
        val mutable = storage.value.toMutableSet()
        mutable.remove(selectedIndex)
        storage.value = mutable
    }

//    AlertDialog(
//        title = title,
//        text = {
//            Column {
//                subtitle?.invoke()
//                items.forEachIndexed { index, item ->
//                    val isSelected by rememberUpdatedState(newValue = state.value.contains(index))
//                    Row(
//                        modifier = Modifier
//                          .fillMaxWidth()
//                          .selectable(
//                            role = Role.Checkbox,
//                            selected = isSelected,
//                            onClick = {
//                              if (isSelected) {
//                                onRemove(index)
//                              } else {
//                                onAdd(index)
//                              }
//                            }
//                          )
//                          .padding(
//                            top = 16.dp,
//                            bottom = 16.dp
//                          )
//                    ) {
//                        Text(
//                            text = item,
//                            style = MaterialTheme.typography.body1,
//                            modifier = Modifier.weight(1f)
//                        )
//                        Checkbox(
//                            checked = isSelected,
//                            onCheckedChange = { checked ->
//                                if (checked) {
//                                    onRemove(index)
//                                } else {
//                                    onAdd(index)
//                                }
//                            }
//                        )
//                    }
//                }
//            }
//        },
//        onDismissRequest = { showDialog = false },
//        confirmButton = {
//            TextButton(
//                onClick = { showDialog = false },
//            ) {
//                ProvideTextStyle(
//                    value = MaterialTheme.typography.button.copy(fontFeatureSettings = "c2sc, smcp")
//                ) {
//                    Text(text = confirmButton)
//                }
//            }
//        }
//    )
}