package com.tahir.pessl_instruments.Helpers

import android.app.ProgressDialog
import android.content.Context


object ProgressDialogHelper {
    /**
     * Show ProgressDialog
     *
     * This method is used to show .
     *
     * @param Context .
     * @return ProgressDialog
     *
     *
     */

    fun showDialog(c: Context): ProgressDialog {
        val pd = ProgressDialog(c)
        pd.setMessage("loading....please wait")
        pd.show()

        return pd
    }

    fun cancelDialog(pDialog: ProgressDialog) {
        pDialog.cancel()
    }

//    companion object {
//        /**
//         * Cancels ProgressDialog
//         *
//         * This method is used to show .
//         *
//         * @param ProgressDialog .
//         *
//         * @return doesnot return anything
//         *
//         *
//         */
//        fun cancelDialog(pDialog: ProgressDialog) {
//            pDialog.cancel()
//        }
//    }


}
