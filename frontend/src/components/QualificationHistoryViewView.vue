<template>

    <v-data-table
        :headers="headers"
        :items="qualificationHistoryView"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'QualificationHistoryViewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            qualificationHistoryView : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/qualificationHistoryViews'))

            temp.data._embedded.qualificationHistoryViews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.qualificationHistoryView = temp.data._embedded.qualificationHistoryViews;
        },
        methods: {
        }
    }
</script>

