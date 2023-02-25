package goshka133.football.feature_auth.screens.auth.presentation

import goshka133.football.feature_auth.screens.auth.presentation.AuthEvent.Internal
import goshka133.football.feature_auth.screens.auth.presentation.AuthEvent.Ui
import vivid.money.elmslie.core.store.dsl_reducer.ScreenDslReducer
import goshka133.football.feature_auth.screens.auth.presentation.AuthCommand as Command
import goshka133.football.feature_auth.screens.auth.presentation.AuthEffect as Effect
import goshka133.football.feature_auth.screens.auth.presentation.AuthEvent as Event
import goshka133.football.feature_auth.screens.auth.presentation.AuthState as State

internal object AuthReducer :
  ScreenDslReducer<Event, Ui, Internal, State, Effect, Command>(Ui::class, Internal::class) {

  override fun Result.ui(event: Ui) {
    when (event) {
      is Ui.System.Start -> Unit
      is Ui.Click.Continue -> {
        if (state.canGoNext) {
          state {
            copy(
              currentNumberPage = state.currentNumberPage + 1,
              previousNumberPage = state.currentNumberPage,
            )
          }
        } else {
          effects { +Effect.OpenMoreInfo }
        }
      }
      is Ui.Click.Back -> {
        if (state.canGoBack) {
          state {
            copy(
              currentNumberPage = currentNumberPage - 1,
              previousNumberPage = state.currentNumberPage,
            )
          }
        } else {
          effects { +Effect.Close }
        }
      }
      is Ui.Action.OnPhoneNumberTextFieldChange -> {
        state {
          copy(
            phoneNumberPage =
            state.phoneNumberPage.copy(
              numberTextFieldValue = event.textFieldValue,
            )
          )
        }
      }
      is Ui.Action.OnSmsTextFieldChange -> {
        state {
          copy(
            smsCodePage =
            state.smsCodePage.copy(
              smsTextFieldValue = event.textFieldValue,
            )
          )
        }
      }
    }
  }

  override fun Result.internal(event: Internal) = Unit
}