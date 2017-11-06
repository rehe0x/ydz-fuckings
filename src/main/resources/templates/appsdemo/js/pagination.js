(function (vue) {
    var template1 = '<div class="page-bar"> \
                     <ul> \
    				<li><a v-bind:class="{ pagebuttondisabled: cur <= 1 }" v-on:click="prvePage(cur)">上一页</a></li> \
                       <li v-for="index in indexs"  v-bind:class="{ active: cur == index }"> \
                          <a v-on:click="btnClick(index)">{{ index < 1 ? "..." : index }}</a> \
                       </li> \
        				<li><a v-bind:class="{ pagebuttondisabled: cur >= all }" v-on:click="nextPage(cur)">下一页</a></li> \
                     </ul> \
                   </div>'
    	
    var template='<div class="am-cf">\
						<div class="am-fr">\
					       <ul class="am-pagination tpl-pagination">\
					            <li  v-bind:class="{ amdisabled: cur <= 1 }" v-on:click="prvePage(cur)"><a href="#">«</a></li>\
					            <li  v-for="index in indexs"  v-bind:class="{ amactive: cur == index }" v-on:click="btnClick(index)"><a href="#">{{ index < 1 ? "..." : index }}</a></li>\
					           <li   v-bind:class="{ amdisabled: cur >= all }" v-on:click="nextPage(cur)"><a href="#">»</a></li>\
					        </ul> \
					    </div>\
					</div>'

    var pagination = vue.extend({
        template: template1,
        props: ['cur', 'all'],
        computed: {
            indexs: function () {
                var left = 1
                var right = this.all
                var ar = []
                if (this.all >= 11) {
                    if (this.cur > 5 && this.cur < this.all - 4) {
                        left = this.cur - 5
                        right = this.cur + 4
                    } else {
                        if (this.cur <= 5) {
                            left = 1
                            right = 10
                        } else {
                            right = this.all
                            left = this.all - 9
                        }
                    }
                }
                while (left <= right) {
                    ar.push(left)
                    left++
                }
                if (ar[0] > 1) {
                    ar[0] = 1;
                    ar[1] = -1;
                }
                if (ar[ar.length - 1] < this.all) {
                    ar[ar.length - 1] = this.all;
                    ar[ar.length - 2] = 0;
                }
                return ar
            }
        },
        methods: {
            btnClick: function (data) {
                if (data < 1) return;
                if (data != this.cur) {
                    this.cur = data
                    //this.$dispatch('btn-click', data)
                    this.$emit('btn-click', data)
                }
            },
            nextPage: function (data) {
                if (this.cur >= this.all) return;
                this.btnClick(this.cur + 1);
            },
            prvePage: function (data) {
                if (this.cur <= 1) return;
                this.btnClick(this.cur - 1);
            },
            setButtonClass: function (isNextButton) {
                if (isNextButton) {
                    return this.cur >= this.all ? "page-button-disabled" : ""
                }
                else {
                    return this.cur <= 1 ? "page-button-disabled" : ""
                }
            }
        }
    })

    vue.Pagination = pagination

})(Vue)