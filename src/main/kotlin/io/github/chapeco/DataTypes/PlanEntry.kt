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
        return Plan()
    }

    fun updatePlanEntry(planId: Int, entryId: Int): Plan
    {
        return Plan()
    }

    fun deletePlanEntry(planId: Int, entryId: Int)
    {

    }
}