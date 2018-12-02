package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON

@Serializable
data class PlanEntry
(
        //ADD
        @SerialName("suite_id") var suiteId: Int? = null,
        @SerialName("config_ids") var configIds: Array<Int>? = null,
        var runs: Array<Run>? = null,

        //ADD/UPDATE
        var name: String? = null,
        var description: String? = null,
        @SerialName("assignedto_id") var assignedToId: Int? = null,
        @SerialName("include_all") var includeAll: Boolean? = null,
        @SerialName("case_ids") var caseIds: Array<Int>? = null
)
{
    //TODO
    fun addPlanEntry(planId: Int, plan: Plan): Plan
    {
        val endpoint = "add_plan_entry/$planId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(plan))!!)
    }

    fun updatePlanEntry(planId: Int, entryId: Int, plan: Plan): Plan
    {
        val endpoint = "update_plan_entry/$planId/$entryId"
        return JSON.unquoted.parse(Request().Post(endpoint,JSON.stringify(plan))!!)
    }

    fun deletePlanEntry(planId: Int, entryId: Int)
    {
        val endpoint = "delete_plan_entry/$planId/$entryId"
        Request().Post(endpoint)
    }
}