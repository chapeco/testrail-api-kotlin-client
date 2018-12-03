package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.MissingRequiredParamException
import io.github.chapeco.Utilities.Request
import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON

@Serializable
data class PlanEntry
(
        //ADD
        @Optional val id: String? = null,
        @Transient val planId: Int? = null,
        @Optional @SerialName("suite_id") var suiteId: Int? = null,
        @Optional @SerialName("config_ids") var configIds: List<Int>? = null,
        @Optional var runs: List<Run>? = null,

        //ADD/UPDATE
        @Optional var name: String? = null,
        @Optional var description: String? = null,
        @Optional @SerialName("assignedto_id") var assignedToId: Int? = null,
        @Optional @SerialName("include_all") var includeAll: Boolean? = null,
        @Optional @SerialName("case_ids") var caseIds: List<Int>? = null
)
{
    //TODO
    fun addPlanEntry(): PlanEntry
    {
        if(this.planId == null) throw MissingRequiredParamException("planId")
        val planId = this.planId
        val endpoint = "add_plan_entry/$planId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun updatePlanEntry(): PlanEntry
    {
        if(this.planId == null) throw MissingRequiredParamException("planId")
        if(this.id == null) throw MissingRequiredParamException("id")
        val planId = this.planId
        val entryId = this.id
        val endpoint = "update_plan_entry/$planId/$entryId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(this))!!)
    }

    fun deletePlanEntry()
    {
        if(this.planId == null) throw MissingRequiredParamException("planId")
        if(this.id == null) throw MissingRequiredParamException("id")
        val planId = this.planId
        val entryId = this.id
        val endpoint = "delete_plan_entry/$planId/$entryId"
        Request().Post(endpoint)
    }
}