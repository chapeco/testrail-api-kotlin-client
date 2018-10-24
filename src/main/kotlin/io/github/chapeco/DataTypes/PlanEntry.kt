package io.github.chapeco.DataTypes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    fun addPlanEntry(planId: Int): Plan
    {
        val endpoint = "add_plan_entry/$planId"
        return Plan()
    }

    fun updatePlanEntry(planId: Int, entryId: Int): Plan
    {
        val endpoint = "update_plan_entry/$planId/$entryId"
        return Plan()
    }

    fun deletePlanEntry(planId: Int, entryId: Int)
    {
        val endpoint = "delete_plan_entry/$planId/$entryId"
    }
}