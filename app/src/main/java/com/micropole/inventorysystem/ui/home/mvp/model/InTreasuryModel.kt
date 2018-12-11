package com.micropole.inventorysystem.ui.home.mvp.model

import com.micropole.inventorysystem.common.AppService
import com.micropole.inventorysystem.entity.TreasuryBean
import com.micropole.inventorysystem.ui.home.mvp.contract.InTreasuryContract
import com.xx.baseutilslibrary.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/11/26
 * describe:
 */
class InTreasuryModel:InTreasuryContract.Model {
    override fun treasuryList(type: Int, page: Int, deac: Int, companyId: String) : Observable<BaseResponseEntity<TreasuryBean>>{
        return AppService.Api!!.treasurylist(type,page,deac,companyId)
    }
}