<template>
  <div>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
      <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Edit Purchase</h6>
      </div>
      <div class="card-body">
        <div class="row">
          <div class="col-sm-4">
            <label>Purchase No.</label>
            {{ info.custom_purchase_id }}
            <br />
            <div class="form-group">
              <label>Status</label>
              <template v-if="info.status === 'Paid'">
                <select class="form-control" v-model="info.status">
                  <option selected style="background: green; color: #fff">
                    Paid
                  </option>
                  <option style="background: red; color: #fff">To Pay</option>
                </select>
              </template>
              <template v-else-if="info.status === 'To Pay'">
                <select class="form-control" v-model="info.status">
                  <option selected style="background: red; color: #fff">
                    To Pay
                  </option>
                  <option style="background: green; color: #fff">Paid</option>
                </select>
              </template>
            </div>
            <div class="form-group" style="position: relative">
              <label>Supplier</label>
              <input
                type="text"
                v-model="info.supplier_name"
                v-on:keyup="autoComplete"
                class="form-control"
              />
              <span v-if="errors['info.supplier_name']" :class="['errorText']">
                {{ errors["info.supplier_name"][0] }}
                <br />
              </span>
              <!-- Search suggestion block -->
              <div class="supplier-search-suggestion">
                <div
                  v-for="queryResult in queryResults"
                  v-bind:key="queryResult.id"
                  class="supplier-search-suggestion-inner"
                >
                  <ul>
                    <li
                      @click="
                        clickSearchSuggestion(queryResult.id, queryResult.name)
                      "
                    >
                      {{ queryResult.name }}
                    </li>
                  </ul>
                </div>
              </div>
              <b-button
                id="show-btn"
                @click="$bvModal.show('bv-modal-example')"
                class="btn btn-warning"
                style="margin-top: 8px"
              >
                <span class="fa fa-plus-circle"></span> Add Supplier
              </b-button>
              <b-modal id="bv-modal-example" hide-footer>
                <template v-slot:modal-title>Add Supplier</template>
                <div class="d-block">
                  <div class="form-group">
                    <input type="hidden" v-model="supplier.id" />
                    <label for="Name">Name:</label>
                    <!--  <input type="text"  v-model="supplier.name" :class="['form-control', errors.name ? 'is-invalid' : '']"> -->
                    <input
                      type="text"
                      v-model="supplier.name"
                      :class="['form-control']"
                    />
                    <span v-if="errors.name" :class="['errorText']">{{
                      errors.name[0]
                    }}</span>
                  </div>
                  <div class="form-group">
                    <label for="Address">Address:</label>
                    <input
                      type="text"
                      v-model="supplier.address"
                      :class="['form-control']"
                    />
                    <span v-if="errors.address" :class="['errorText']">{{
                      errors.address[0]
                    }}</span>
                  </div>

                  <div class="form-group">
                    <label for="Phone">Phone:</label>
                    <input
                      type="phone"
                      v-model="supplier.phone"
                      :class="['form-control']"
                    />
                    <span v-if="errors.phone" :class="['errorText']">{{
                      errors.phone[0]
                    }}</span>
                  </div>
                  <div class="form-group">
                    <label for="Opening_balance">Opening Balance:</label>
                    <input
                      type="text"
                      v-model="supplier.opening_balance"
                      :class="['form-control']"
                    />
                    <span
                      v-if="errors.opening_balance"
                      :class="['errorText']"
                      >{{ errors.opening_balance[0] }}</span
                    >
                  </div>
                  <div class="form-group">
                    <label for="Phone">Details:</label>
                    <textarea
                      v-model="supplier.details"
                      :class="['form-control']"
                    ></textarea>
                    <span v-if="errors.details" :class="['errorText']">{{
                      errors.details[0]
                    }}</span>
                  </div>
                </div>
                <b-button class="mt-3" block @click="addSupplier"
                  >Add Supplier</b-button
                >
              </b-modal>
              <!-- Search suggestion block ends -->
            </div>
          </div>
          <div class="col-sm-4">
            <div class="form-group">
              <!--   <label>Supplier Address</label>
            <textarea class="form-control" style="height: 7.6em" v-model="info.client_address"></textarea>
                
              -->
            </div>
          </div>
          <div class="col-sm-4">
            <div class="form-group">
              <label>Note</label>
              <textarea v-model="info.note" class="form-control"></textarea>
              <span v-if="errors['info.note']" :class="['errorText']">{{
                errors["info.note"][0]
              }}</span>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <label>Purchase Date</label>
                <date-picker
                  v-model="info.purchase_date"
                  :config="options"
                  :class="['form-control']"
                ></date-picker>
                <!-- <input type="date" v-model="info.purchase_date" class="form-control"> -->
                <span
                  v-if="errors['info.purchase_date']"
                  :class="['errorText']"
                  >{{ errors["info.purchase_date"][0] }}</span
                >
              </div>
              <div class="col-sm-6">
                <label>Due Date</label>
                <!-- <input type="date" v-model="info.due_date" class="form-control">    -->
                <date-picker
                  v-model="info.due_date"
                  :config="options"
                  :class="['form-control']"
                ></date-picker>
                <span v-if="errors['info.due_date']" :class="['errorText']">{{
                  errors["info.due_date"][0]
                }}</span>
              </div>
            </div>
          </div>
        </div>
        <hr />
        <div class="purchase">
          <div class="purchase-head">
            <div class="row">
              <div class="col-md-1">
                <h6>ID</h6>
              </div>
              <div class="col-md-3">
                <h6>Product Name</h6>
              </div>
              <div class="col-md-1">
                <h6>Quanity</h6>
              </div>
              <div class="col-md-1">
                <h6>Unit</h6>
              </div>
              <div class="col-md-2">
                <h6>Price</h6>
              </div>
              <div class="col-md-2">
                <h6>Total</h6>
              </div>
              <div class="col-md-2">
                <h6>Action</h6>
              </div>
            </div>
          </div>
          <!-- end of purchase head-->
          <div class="purchase-body">
            <div
              class="purchase-items"
              v-for="(item, index) in items"
              v-bind:key="item.id"
            >
              <div class="row">
                <div
                  class="col-md-1"
                  v-if="item.product.custom_product_id != null"
                >
                  {{ item.product.custom_product_id }} | {{ item.stock_id }}
                </div>

                <div class="col-md-1" v-else>#</div>
                <div class="col-md-3">
                  <div class="auto-complete-product-container">
                    <div class="form-group">
                      <input
                        type="text"
                        class="form-control"
                        placeholder="Product Name"
                        v-model="item.product_name"
                        v-on:keydown="autoCompleteProduct(index)"
                        :class="{
                          'is-invalid':
                            errors['items.' + index + '.product_name'],
                        }"
                      />

                      <span
                        v-if="errors['items.' + index + '.product_name']"
                        :class="['errorText']"
                        >{{
                          errors["items." + index + ".product_name"][0]
                        }}</span
                      >

                      <!--  suggestion block -->
                      <div class="product-search-suggestion-purchase">
                        <ul>
                          <li
                            v-for="queryResultsProduct in queryResultsProducts[
                              index
                            ]"
                            v-bind:key="queryResultsProduct.id"
                            @click="
                              clickSearchProductSuggestion(
                                queryResultsProduct.id,
                                queryResultsProduct.product.id,
                                queryResultsProduct.product.custom_product_id,
                                queryResultsProduct.product.name,
                                queryResultsProduct.product.unit.id,
                                queryResultsProduct.product.sp,
                                index
                              )
                            "
                          >
                            {{ queryResultsProduct.product.name }} --
                            {{ queryResultsProduct.quantity }}
                            {{ queryResultsProduct.product.unit.short_name }} --
                            Rs. {{ queryResultsProduct.price }}
                          </li>
                        </ul>
                      </div>
                      <!--  <span v-if="errors['items.' + index + '.product_name']">
                      {{ errors['items.' + index + '.product_name'] }}
                    </span> -->
                    </div>
                  </div>
                </div>
                <div class="col-md-1">
                  <input
                    type="number"
                    class="form-control"
                    placeholder="Quantity"
                    v-model="item.quantity"
                    :class="{
                      'is-invalid': errors['items.' + index + '.quantity'],
                    }"
                  />
                </div>
                <div class="col-md-1">
                  <template v-if="units.length > 0">
                    <select
                      class="form-control"
                      disabled=""
                      v-model="item.unit_id"
                      v-if="item.product_id"
                      :class="{
                        'is-invalid': errors['items.' + index + '.id'],
                      }"
                    >
                      <option
                        selected
                        v-for="unit in units"
                        :value="unit.id"
                        v-bind:key="unit.id"
                      >
                        {{ unit.short_name }}
                      </option>
                    </select>
                  </template>
                  <template v-else>add some unit</template>
                </div>
                <div class="col-md-2">
                  <input
                    type="text"
                    class="form-control"
                    placeholder="Enter the price"
                    v-model="item.price"
                    v-if="item.product_id"
                    :class="{
                      'is-invalid': errors['items.' + index + '.price'],
                    }"
                  />
                </div>
                <div class="col-md-2">
                  <span class="table-text">{{
                    item.quantity * item.price
                  }}</span>
                </div>
                <div class="col-md-2">
                  <button
                    href
                    class="btn btn-danger"
                    style="border: none"
                    @click="removeLine(index)"
                  >
                    <span
                      class="nc-icon nc-simple-remove"
                      style="font-size: 15px"
                    ></span>
                  </button>
                </div>
              </div>
            </div>
            <!-- end of purchase items-->
          </div>
          <!-- end of purchase body-->
          <div class="purchase-foot">
            <div class="row">
              <div class="col-md-2">
                <!--  <button class="table-add_line btn btn-primary" @click="addNewLine">
                  <span class="fa fa-plus-circle"></span>
                </button> -->
              </div>
              <div class="col-md-2">
                <h6>Grand Total</h6>
                {{ grandTotal }}
              </div>
              <div class="col-md-2">
                <h6>Discount</h6>
                <input
                  type="text"
                  class="table-discount_input form-control"
                  v-model="info.discount"
                  :class="{ 'is-invalid': errors['info.discount'] }"
                />
                <span v-if="errors['info.discount']" :class="['errorText']">{{
                  errors["info.discount"][0]
                }}</span>
              </div>
              <div class="col-md-2">
                <h6>{{ store.tax_percentage }} % Tax</h6>
                {{ taxAmount }}
              </div>
              <div class="col-md-2">
                <h6>SubTotal</h6>
                {{ subTotal }}
              </div>
              <div class="col-md-2"></div>
            </div>
          </div>
          <!-- end of purchase foot -->
        </div>
        <!-- end of purchase -->
        <button class="btn btn-success" @click="updatePurchase">Update</button>
        <router-link to="/purchases" class="btn btn-danger">Close</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: [
        {
          product_name: "",
          price: "",
          quantity: "",
          product: {
            custom_product_id: "",
            unit: {},
          },
          line_total: "",
          changed: false,
        },
      ],
      cloneItems: [
        {
          product_name: "",
          price: "0",
          quantity: "1",
          product: {
            custom_product_id: "",
            unit: {},
          },
          line_total: "",
          changed: false,
        },
      ],
      store: {},

      info: {},
      id: "",
      supplier: {},
      showModal: false,
      queryResults: [],
      queryResultsProducts: [],
      errors: [],
      units: [],

      showProductSuggestion: false,

      options: {
        format: "YYYY-MM-DD",
        useCurrent: true,
        showClear: true,
        showClose: true,
      }, //this variable for the date picker
    };
  },
  async mounted() {
    //methods to be executed while this page is created
    await this.getIdFromUrl();
    await this.fetchPurchase();
    this.fetchUnits();
    this.fetchStore();
  },

  methods: {
    fetchStore() {
      let currObj = this;

      axios
        .get("/api/store")

        .then(function (response) {
          Vue.set(currObj.store, "id", response.data.store.id),
            // Vue.set(currObj.store, 'name', response.data.store.name),
            // Vue.set(currObj.store, 'detail', response.data.store.detail),
            Vue.set(
              currObj.store,
              "tax_number",
              response.data.store.tax_number
            ),
            Vue.set(
              currObj.store,
              "tax_percentage",
              response.data.store.tax_percentage
            );
          // Vue.set(currObj.store, 'email', response.data.store.email),
          // Vue.set(currObj.store, 'address', response.data.store.address),
          // Vue.set(currObj.store, 'phone', response.data.store.phone),
          // Vue.set(currObj.store, 'mobile', response.data.store.mobile),
          // Vue.set(currObj.store, 'url', response.data.store.url),
          // //company image
          // Vue.set(currObj.store, 'store_logo',"/img/"+ response.data.store.store_logo),

          // this.company_logo="/img/"+data.store.company_logo //concatenate image location and image name

          // console.log(data.store.company_name)
        });
    }, //end of fetchStores()

    //fetch(){} //all memeber functions will be created here
    addNewLine() {
      this.items.push({
        product_name: "",
        price: "0",
        quantity: "1",
        product: {
          custom_product_id: "",
          unit: {},
        },
        line_total: "",
        changed: false,
      });

      this.cloneItems.push({
        product_name: "",
        price: "0",
        quantity: "1",
        product: {
          custom_product_id: "",
          unit: {},
        },
        line_total: "",
        changed: false,
      });
    }, // end of add new line
    removeLine(index) {
      // this.purchases.remove();
      if (index != 0) {
        this.items.splice(index, 1);
      } else {
        // alert('You can\'t delete this');
        this.$toast.error({
          title: "Opps!!",
          message: "You can't delete this.",
        });
      }
    }, //end of removeLine function

    calLineTotal(index) {
      // alert(this.purchases[index].price);
      this.items[index].line_total =
        this.items[index].price * this.items[index].quantity;
    },
    updatePurchase() {
      if (this.info.discount == null || this.info.discount == "") {
        this.info.discount = 0;
      }

      let currObj = this;
      axios
        .put("/api/purchase", {
          info: this.info,
          items: this.items,
          id: this.id,
        })
        .then(function (response) {
          currObj.output = response.data.msg;
          currObj.status = response.data.status;
          currObj.$swal("Info", currObj.output, currObj.status);
          currObj.$router.push({ name: "purchases" });
          // currObj.errors = '';//clearing errors
        })
        .catch(function (error) {
          if (error.response.status == 422) {
            currObj.validationErrors = error.response.data.errors;
            currObj.errors = currObj.validationErrors;
            // console.log(currObj.errors);
            currObj.$toast.error({
              title: "Opps!!",
              message: error.response.data.message,
            });
          }
        });
    },

    getIdFromUrl() {
      this.id = this.$route.params.id;
    }, //end of getIdFromUrl
    addSupplier() {
      let currObj = this;
      axios
        .post("/api/supplier", this.supplier)
        .then(function (response) {
          currObj.output = response.data.msg;
          currObj.status = response.data.status;
          currObj.$swal("Info", currObj.output, currObj.status);

          currObj.$bvModal.hide("bv-modal-add-supplier");

          currObj.supplier.name = "";
          currObj.supplier.address = "";
          currObj.supplier.phone = "";
          currObj.supplier.details = "";

          currObj.errors = ""; //clearing errors

          currObj.fetchSuppliers();
        })
        .catch(function (error) {
          if (error.response.status == 422) {
            currObj.validationErrors = error.response.data.errors;
            currObj.errors = currObj.validationErrors;
            // console.log(currObj.errors);
            currObj.$toast.error({
              title: "Opps!!",
              message: error.response.data.message,
            });
          }
        });
    },
    autoComplete: _.debounce(function () {
      let currObj = this;
      if (this.info.supplier_name === "") {
        this.queryResults = null;
      } else {
        axios
          .post("api/supplier/search", {
            searchQuery: this.info.supplier_name,
          })
          .then((response) => {
            this.queryResults = response.data.queryResults;
          })
          .catch((error) => {
            if (error.response.status == 422) {
              currObj.validationErrors = error.response.data.errors;
              currObj.errors = currObj.validationErrors;
              // console.log(currObj.errors);
              currObj.$toast.error({
                title: "Opps!!",
                message: error.response.data.message,
              });
            }
          });
      }
    }, 500),

    autoCompleteProduct: _.debounce(function (index) {
      if (this.items[index].product_name === "") {
        this.items[index].product_id = "";
        this.cloneItems[index].product_id == "";
        this.queryResultsProducts = new Array();
        this.showProductSuggestion = false;
      } else {
        axios
          .post("/api/products/search", {
            searchQuery: this.items[index].product_name,
          })
          .then((response) => {
            this.queryResultsProducts[index] = response.data.data;

            if (this.queryResultsProducts[index].length > 0) {
              this.showProductSuggestion = true;
            } else {
              this.showProductSuggestion = false;
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
      // alert(this.items[index].product_name);
    }, 300),
    //will find item exits in that items array or not
    //used to elimate duplicate produt/item in items/products
    hasItem(key) {
      if (this.items.find((item) => item.stock_id === key)) {
        return true;
      } else {
        return false;
      }
    },

    clickSearchProductSuggestion(
      stock_id,
      product_id,
      custom_product_id,
      product_name,
      unit_id,
      cp,
      index
    ) {
      if (!this.hasItem(stock_id)) {
        // console.log("Item not in List. So adding");
        Vue.set(this.items[index], "product_id", product_id);

        Vue.set(this.items[index], "custom_product_id", custom_product_id);

        Vue.set(this.items[index], "product_name", product_name);

        Vue.set(this.items[index], "unit_id", unit_id);

        Vue.set(this.items[index], "stock_id", stock_id);

        Vue.set(this.items[index], "price", parseFloat(cp));

        Vue.set(this.cloneItems[index], "product_id", product_id);

        Vue.set(this.cloneItems[index], "custom_product_id", custom_product_id);

        Vue.set(this.cloneItems[index], "product_name", product_name);

        Vue.set(this.cloneItems[index], "unit_id", unit_id);

        Vue.set(this.items[index], "stock_id", stock_id);

        Vue.set(this.cloneItems[index], "price", parseFloat(cp));

        // this.items[index] = this.items[index] + (this.store.profit_percentage)/100;

        // console.log(product_id);
        // console.log(product_name);
        // console.log(index);
        this.queryResultsProducts = new Array();
      } else {
        // console.log("Item exits in list so deleting the current index item to remove duplicate entry in items array");
        this.displayToastErrorMessage(
          "Opps",
          product_name +
            " already on the list. You can increase the quantity or choose different stock "
        );

        this.items.splice(index);

        this.cloneItems.splice(index);

        this.queryResultsProducts = new Array();
      }
    },

    clickSearchSuggestion(supplier_id, supplier_name) {
      Vue.set(this.info, "supplier_id", supplier_id);
      Vue.set(this.info, "supplier_name", supplier_name);
      this.queryResults = null;
    },
    fetchPurchase() {
      let currObj = this;

      axios
        .get("/api/purchase/" + this.id)
        .then(function (response) {
          Vue.set(currObj.info, "purchase_no", response.data.purchase.id),
            Vue.set(currObj.info, "note", response.data.purchase.note),
            Vue.set(
              currObj.info,
              "custom_purchase_id",
              response.data.purchase.custom_purchase_id
            ),
            Vue.set(currObj.info, "title", response.data.purchase.title),
            Vue.set(
              currObj.info,
              "supplier_id",
              response.data.purchase.supplier_id
            ),
            Vue.set(
              currObj.info,
              "supplier_name",
              response.data.purchase.supplier_name
            ),
            Vue.set(
              currObj.info,
              "purchase_date",
              response.data.purchase.purchase_date
            ),
            Vue.set(currObj.info, "due_date", response.data.purchase.due_date),
            Vue.set(currObj.info, "discount", response.data.purchase.discount),
            Vue.set(currObj.info, "status", response.data.purchase.status),
            //veu.set will make data reactive and updated
            (currObj.items = response.data.purchase.purchase_detail),
            (currObj.cloneItems = currObj.items);
        })
        .catch(function (error) {
          if (error.response.status == 404) {
            currObj.$router.push({ name: "404" });
          }
        });
    }, //end of fetchPurchase

    fetchUnits() {
      let vm = this; // current pointer instance while going inside the another functional instance
      axios
        .get("/api/units")
        .then(function (response) {
          vm.units = response.data.data;
        })
        .catch(function (error) {
          console.log();
        });
    },
  }, // end of methods

  computed: {
    subTotal: function () {
      //reduce function is used to sum the array elements
      this.info.subTotal = this.items.reduce(function (carry, item) {
        return carry + parseFloat(item.quantity) * parseFloat(item.price);
      }, 0);
      return this.info.subTotal;
    },
    setPurchaseVars: function () {},

    taxAmount: function () {
     return this.subTotal * parseFloat(this.store.tax_percentage/100);
    },

    grandTotal: function () {
      if (this.info.discount != null) {
        return this.subTotal - parseFloat(this.info.discount) + this.taxAmount;
      } else {
        return this.subTotal + this.taxAmount;
      }
    },
  }, //end of computed

  watch: {
    "info.title": function (val, oldVal) {
      // console.log(this.errors['info.title'][0]);
      if (this.errors != "") {
        this.errors["info.title"][0] = "";
      }
    },

    "info.due_date": function (val, oldVal) {
      // console.log('due_date changes');
      if (this.errors != "") {
        this.errors["info.due_date"][0] = "";
      }
    },

    "info.purchase_date": function (val, oldVal) {
      // console.log('estimate_date changes');
      if (this.errors != "") {
        this.errors["info.purchase_date"][0] = "";
      }
    },

    "info.supplier_name": function (val, oldVal) {
      // console.log('supplier_name changes');
      if (this.errors != "") {
        this.errors["info.supplier_name"][0] = "";
      }
    },
  }, //end of watch
}; //end of export default
</script>

<style>
.purchase {
  margin-top: 5em;
}

.purchase-body {
  margin-top: 2em;
  padding: 8px;
}

.purchase-head {
  padding: 1em;
  /*border-bottom: 1px solid #eee;*/
  background: coral;
  color: white;
  box-shadow: 1px 7px 17px -12px;
}

.purchase-foot {
  margin-top: 1em;
  padding: 2em;
  border-top: 1px solid #eee;
}

.datetime-picker {
}

.datetime-picker input {
  display: block;
  width: 100%;
  height: calc(1.5em + 0.75rem + 2px);
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

.supplier-search-suggestion {
  background: #fff;
  position: absolute;
  overflow-y: scroll;
  height: auto;
  max-height: 9em;
  color: #000;
  border: 1px solid #e2dfdf;
  border-top: 0px;
  width: 100%;
  box-shadow: 1px 7px 17px -12px;
  border-radius: 4px;
}

.supplier-search-suggestion-inner {
  padding: 1px;
  border-top: 1px solid #d6d6d6;
}

.supplier-search-suggestion-inner ul {
  list-style: none;
  margin: 0;
  padding: 0;
}

.supplier-search-suggestion-inner li {
  cursor: pointer;
  padding: 10px;
}

.supplier-search-suggestion-inner li:hover {
  background: #007bff;
  color: #fff;
}

.supplier-search-suggestion::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  background-color: #f5f5f5;
}

.supplier-search-suggestion::-webkit-scrollbar {
  width: 6px;
  background-color: #f5f5f5;
}

.supplier-search-suggestion::-webkit-scrollbar-thumb {
  background-color: #000000;
}

.product-search-suggestion-purchase {
  position: absolute;
  /* background: #f4f3ef; */
  width: 100%;
  color: #212120;
  /* padding-right: 12px; */
  overflow-y: scroll;
  max-height: 9em;
  z-index: 1;
  box-shadow: 1px 7px 17px -12px;
  border-radius: 4px;
}

.product-search-suggestion-purchase ul {
  list-style: none;
  margin: 0px;
  padding: 0px;
}

.product-search-suggestion-purchase ul li {
  padding: 10px;
  cursor: pointer;
  background: #f4f3ef;
}

.product-search-suggestion-purchase ul li:hover {
  background: #51cbce;
  color: white;
}

.product-search-suggestion-purchase::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  background-color: #f5f5f5;
}

.product-search-suggestion-purchase::-webkit-scrollbar {
  width: 6px;
  background-color: #f5f5f5;
}

.product-search-suggestion-purchase::-webkit-scrollbar-thumb {
  background-color: #000000;
}
</style>
