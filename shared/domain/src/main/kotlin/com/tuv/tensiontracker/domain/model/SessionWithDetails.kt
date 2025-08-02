package com.tuv.tensiontracker.domain.model

data class SessionWithDetails(
    val session: StringingSession,
    val mainString: StringModel,
    val crossString: StringModel?,
    val feedback: SessionFeedback?
) {
    val stringSetupDescription: String
        get() = if (session.isHybrid && crossString != null) {
            "${mainString.displayName} / ${crossString.displayName}"
        } else {
            mainString.displayName
        }
        
    val tensionDescription: String
        get() = if (session.isHybrid && session.crossTension != null) {
            "${session.mainTension} / ${session.crossTension}"
        } else {
            session.mainTension.toString()
        }
}