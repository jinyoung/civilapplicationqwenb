<template>

    <v-data-table
        :headers="headers"
        :items="documentHistoryView"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DocumentHistoryViewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            documentHistoryView : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/documentHistoryViews'))

            temp.data._embedded.documentHistoryViews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.documentHistoryView = temp.data._embedded.documentHistoryViews;
        },
        methods: {
        }
    }
</script>

