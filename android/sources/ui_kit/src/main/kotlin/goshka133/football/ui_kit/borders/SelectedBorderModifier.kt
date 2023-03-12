package goshka133.football.ui_kit.borders

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import goshka133.football.ui_kit.theme.DefaultShapes
import goshka133.football.ui_kit.theme.FootballColors

val SelectedBorderModifier =
  Modifier.border(
    width = 1.dp,
    color = FootballColors.Primary,
    shape = DefaultShapes.large,
  )
