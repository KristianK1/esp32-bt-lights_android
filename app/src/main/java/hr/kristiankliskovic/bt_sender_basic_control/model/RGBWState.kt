package hr.kristiankliskovic.bt_sender_basic_control.model

data class RGBWState (
    var R: Float,
    var G: Float,
    var B: Float,
    var W: Float,
){
    companion object {
        fun empty(): RGBWState {
            return RGBWState(0f, 0f, 0f, 0f);
        }
    }
}
