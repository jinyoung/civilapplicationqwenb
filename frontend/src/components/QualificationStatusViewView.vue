<template>

    <v-data-table
        :headers="headers"
        :items="qualificationStatusView"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'QualificationStatusViewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            qualificationStatusView : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/qualificationStatusViews'))

            temp.data._embedded.qualificationStatusViews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.qualificationStatusView = temp.data._embedded.qualificationStatusViews;
        },
        methods: {
        }
    }
</script>

